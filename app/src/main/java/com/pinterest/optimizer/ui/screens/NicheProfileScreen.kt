package com.pinterest.optimizer.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.pinterest.optimizer.ui.viewmodel.NicheProfileViewModel
import com.pinterest.optimizer.ui.viewmodel.NicheProfileUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NicheProfileScreen(
    navController: NavHostController,
    viewModel: NicheProfileViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Your Niche", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            when (val state = uiState) {
                is NicheProfileUiState.Loading -> {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
                    }
                }
                
                is NicheProfileUiState.Empty, is NicheProfileUiState.Success -> {
                    NicheProfileForm(
                        initialProfile = (state as? NicheProfileUiState.Success)?.profile,
                        onSave = { niche, description ->
                            viewModel.saveProfile(niche, description)
                            navController.popBackStack()
                        }
                    )
                }
                
                is NicheProfileUiState.Error -> {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(state.message, color = MaterialTheme.colorScheme.error)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun NicheProfileForm(
    initialProfile: com.pinterest.optimizer.data.models.NicheProfile? = null,
    onSave: (String, String) -> Unit
) {
    var selectedNiche by remember { mutableStateOf(initialProfile?.niche ?: "") }
    var customDescription by remember { mutableStateOf(initialProfile?.description ?: "") }
    
    val nicheOptions = listOf(
        "Home Decor", "Fashion", "Food & Recipes", "Fitness", "Travel",
        "DIY & Crafts", "Beauty", "Wellness", "Business", "Education"
    )
    
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 24.dp)
    ) {
        item {
            Text(
                "Customize your focus",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
            Text(
                "This helps us optimize your content for the right audience.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        
        item {
            Spacer(modifier = Modifier.height(8.dp))
            Text("Select a category", style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold)
        }

        item {
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                nicheOptions.forEach { niche ->
                    val isSelected = selectedNiche == niche
                    Surface(
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .clickable { selectedNiche = niche },
                        color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                        contentColor = if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface
                    ) {
                        Text(
                            text = niche,
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                            style = MaterialTheme.typography.labelLarge,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
        
        item {
            Spacer(modifier = Modifier.height(16.dp))
            Text("Detailed focus", style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = customDescription,
                onValueChange = { customDescription = it },
                placeholder = { Text("e.g., Modern minimalist kitchen designs...") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                shape = RoundedCornerShape(16.dp)
            )
        }
        
        item {
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = { onSave(selectedNiche, customDescription) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(28.dp),
                enabled = selectedNiche.isNotEmpty()
            ) {
                Text("Save and Continue", fontWeight = FontWeight.Bold)
            }
        }
    }
}
