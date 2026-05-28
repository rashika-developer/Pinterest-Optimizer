package com.pinterest.optimizer

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.work.*
import com.pinterest.optimizer.data.worker.SyncWorker
import com.pinterest.optimizer.ui.screens.*
import com.pinterest.optimizer.ui.theme.PinterestOptimizerTheme
import com.pinterest.optimizer.ui.viewmodel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    
    private lateinit var authViewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            authViewModel = hiltViewModel()
            PinterestOptimizerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation(authViewModel)
                }
            }
        }
        handleIntent(intent)
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent) {
        val data = intent.data
        if (data != null && data.scheme == "pinto" && data.host == "oauth") {
            val code = data.getQueryParameter("code")
            if (code != null) {
                authViewModel.handleAuthCode(code)
            }
        }
    }
}

@Composable
fun AppNavigation(
    authViewModel: AuthViewModel
) {
    val navController = rememberNavController()
    val currentAccount by authViewModel.currentAccount.collectAsState()
    val context = LocalContext.current
    
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    LaunchedEffect(currentAccount) {
        if (currentAccount != null) {
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()

            val syncRequest = PeriodicWorkRequestBuilder<SyncWorker>(1, TimeUnit.HOURS)
                .setConstraints(constraints)
                .build()

            WorkManager.getInstance(context).enqueueUniquePeriodicWork(
                "PinterestSync",
                ExistingPeriodicWorkPolicy.KEEP,
                syncRequest
            )
        } else {
            WorkManager.getInstance(context).cancelUniqueWork("PinterestSync")
        }
    }

    val showBottomBar = currentAccount != null && 
            currentDestination?.route in listOf("home", "analytics", "niche_profile")

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                NavigationBar {
                    val items = listOf(
                        Triple("home", "Home", Icons.Default.Home),
                        Triple("analytics", "Analytics", Icons.Default.BarChart),
                        Triple("niche_profile", "Profile", Icons.Default.Person)
                    )
                    items.forEach { (route, label, icon) ->
                        NavigationBarItem(
                            icon = { Icon(icon, contentDescription = label) },
                            label = { Text(label) },
                            selected = currentDestination?.hierarchy?.any { it.route == route } == true,
                            onClick = {
                                navController.navigate(route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        val startDestination = if (currentAccount != null) "home" else "login"
        
        NavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("login") {
                LoginScreen(navController, authViewModel)
            }
            composable("home") {
                HomeScreen(navController)
            }
            composable("niche_profile") {
                NicheProfileScreen(navController)
            }
            composable("post_creation") {
                PostCreationScreen(navController)
            }
            composable("analytics") {
                AnalyticsScreen(navController)
            }
            composable("settings") {
                SettingsScreen(navController)
            }
            composable(
                route = "pin_detail/{postId}",
                arguments = listOf(navArgument("postId") { type = NavType.IntType })
            ) { backStackEntry ->
                val postId = backStackEntry.arguments?.getInt("postId") ?: 0
                PinDetailScreen(postId, navController)
            }
        }
    }
}
