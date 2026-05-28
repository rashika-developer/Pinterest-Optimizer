package com.pinterest.optimizer.ui.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AddPhotoAlternate
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.pinterest.optimizer.ui.viewmodel.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostCreationScreen(
    navController: NavHostController,
    viewModel: PostCreationViewModel = hiltViewModel()
) {
    val captionState by viewModel.captionState.collectAsState()
    val hashtagState by viewModel.hashtagState.collectAsState()
    val boardState by viewModel.boardState.collectAsState()
    val analysisState by viewModel.analysisState.collectAsState()
    val isSaved by viewModel.saveState.collectAsState()
    
    var imageDescription by remember { mutableStateOf("") }
    var selectedCaption by remember { mutableStateOf("") }
    var selectedBoard by remember { mutableStateOf("General") }
    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
    var isScheduling by remember { mutableStateOf(false) }

    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        selectedImageUri = uri
        uri?.let { viewModel.analyzeImage(it.toString()) }
    }
    
    LaunchedEffect(isSaved) {
        if (isSaved) {
            navController.popBackStack()
        }
    }
    
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Create Pin", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    TextButton(
                        onClick = { 
                            val hashtags = if (hashtagState is HashtagState.Success) {
                                (hashtagState as HashtagState.Success).data.hashtags.joinToString(" ")
                            } else ""
                            
                            viewModel.savePost(
                                description = imageDescription,
                                caption = selectedCaption,
                                hashtags = hashtags,
                                imageUri = selectedImageUri?.toString() ?: "",
                                boardName = selectedBoard,
                                scheduledTime = if (isScheduling) System.currentTimeMillis() + 3600000 else System.currentTimeMillis()
                            )
                        },
                        enabled = selectedCaption.isNotEmpty() && selectedImageUri != null
                    ) {
                        Text("Create", fontWeight = FontWeight.Bold, color = if (selectedCaption.isNotEmpty() && selectedImageUri != null) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline)
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(paddingValues).padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            // Image Section
            item {
                Box(
                    modifier = Modifier.fillMaxWidth().aspectRatio(0.8f).clip(RoundedCornerShape(16.dp)).background(MaterialTheme.colorScheme.surfaceVariant).clickable { photoPickerLauncher.launch("image/*") },
                    contentAlignment = Alignment.Center
                ) {
                    if (selectedImageUri != null) {
                        AsyncImage(model = selectedImageUri, contentDescription = null, modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
                        if (analysisState is AnalysisState.Success) {
                            Surface(modifier = Modifier.align(Alignment.TopStart).padding(12.dp), color = MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(12.dp)) {
                                Text("AI Analyzed", color = Color.White, modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp), style = MaterialTheme.typography.labelSmall)
                            }
                        }
                    } else {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(Icons.Default.AddPhotoAlternate, null, modifier = Modifier.size(48.dp), tint = MaterialTheme.colorScheme.primary)
                            Text("Tap to add an image", fontWeight = FontWeight.Medium)
                        }
                    }
                }
            }

            // Scheduling
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
                ) {
                    Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Schedule, null, tint = MaterialTheme.colorScheme.primary)
                        Spacer(modifier = Modifier.width(12.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text("Post Schedule", style = MaterialTheme.typography.labelMedium, fontWeight = FontWeight.Bold)
                            Text(text = if (!isScheduling) "Post immediately" else "Scheduled for later (in 1 hour)", style = MaterialTheme.typography.bodySmall)
                        }
                        Switch(checked = isScheduling, onCheckedChange = { isScheduling = it })
                    }
                }
            }

            // Board Suggestion
            item {
                Column {
                    OutlinedButton(
                        onClick = { viewModel.suggestBoard(imageDescription) },
                        modifier = Modifier.fillMaxWidth(),
                        enabled = imageDescription.isNotEmpty(),
                        shape = RoundedCornerShape(24.dp)
                    ) {
                        if (boardState is BoardState.Loading) {
                            CircularProgressIndicator(modifier = Modifier.size(18.dp), strokeWidth = 2.dp)
                        } else {
                            Icon(Icons.Default.AutoAwesome, null, modifier = Modifier.size(18.dp))
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Suggest Best Board")
                    }
                    Text("AI analyzes your content to find the right board on your account.", style = MaterialTheme.typography.labelSmall, modifier = Modifier.padding(start = 12.dp, top = 4.dp))
                    
                    AnimatedVisibility(visible = boardState is BoardState.Success) {
                        if (boardState is BoardState.Success) {
                            val board = (boardState as BoardState.Success).data.boardName
                            Spacer(modifier = Modifier.height(12.dp))
                            Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f))) {
                                Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
                                    Text("Suggested: $board", modifier = Modifier.weight(1f), style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold)
                                    Button(onClick = { selectedBoard = board }, shape = RoundedCornerShape(12.dp), colors = ButtonDefaults.buttonColors(containerColor = if (selectedBoard == board) Color.Gray else MaterialTheme.colorScheme.primary)) {
                                        Text(if (selectedBoard == board) "Applied" else "Apply")
                                    }
                                }
                            }
                        }
                    }
                }
            }

            item {
                OutlinedTextField(
                    value = imageDescription,
                    onValueChange = { imageDescription = it },
                    placeholder = { Text("What is this Pin about?") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp)
                )
            }

            item {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Button(onClick = { viewModel.generateCaptions(imageDescription) }, modifier = Modifier.weight(1f), enabled = imageDescription.isNotEmpty(), shape = RoundedCornerShape(24.dp)) { Text("AI Captions") }
                    Button(onClick = { viewModel.generateHashtags(imageDescription) }, modifier = Modifier.weight(1f), enabled = imageDescription.isNotEmpty(), shape = RoundedCornerShape(24.dp)) { Text("AI Hashtags") }
                }
            }
            
            // AI Results
            when (val state = captionState) {
                is CaptionState.Loading -> { item { LinearProgressIndicator(modifier = Modifier.fillMaxWidth()) } }
                is CaptionState.Success -> {
                    item {
                        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                            Text("Choose a Caption Style", style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold)
                            CaptionOptionCard(title = "Engaging", caption = state.data.engaging, isSelected = selectedCaption == state.data.engaging, onClick = { selectedCaption = state.data.engaging })
                            CaptionOptionCard(title = "Minimal", caption = state.data.minimal, isSelected = selectedCaption == state.data.minimal, onClick = { selectedCaption = state.data.minimal })
                        }
                    }
                }
                else -> {}
            }
            
            when (val state = hashtagState) {
                is HashtagState.Loading -> { item { LinearProgressIndicator(modifier = Modifier.fillMaxWidth()) } }
                is HashtagState.Success -> {
                    item { HashtagDisplay(hashtags = state.data.hashtags, trendingHashtags = state.data.trending) }
                }
                else -> {}
            }
        }
    }
}

@Composable
fun CaptionOptionCard(title: String, caption: String, isSelected: Boolean, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(title, style = MaterialTheme.typography.labelMedium, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
            Spacer(modifier = Modifier.height(4.dp))
            Text(caption, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Composable
fun HashtagDisplay(hashtags: List<String>, trendingHashtags: List<String>) {
    Surface(
        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(hashtags.joinToString(" "), style = MaterialTheme.typography.bodySmall)
            if (trendingHashtags.isNotEmpty()) {
                Spacer(modifier = Modifier.height(8.dp))
                Text("Trending: " + trendingHashtags.joinToString(" "), style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.primary)
            }
        }
    }
}
