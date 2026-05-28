package com.pinterest.optimizer.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pinterest.optimizer.data.api.BoardRequest
import com.pinterest.optimizer.data.api.ImageAnalysisRequest
import com.pinterest.optimizer.data.models.*
import com.pinterest.optimizer.data.repository.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import javax.inject.Inject

// Niche Profile ViewModel
@HiltViewModel
class NicheProfileViewModel @Inject constructor(
    private val nicheRepository: NicheProfileRepository
) : ViewModel() {
    
    private val _uiState = MutableStateFlow<NicheProfileUiState>(NicheProfileUiState.Loading)
    val uiState: StateFlow<NicheProfileUiState> = _uiState.asStateFlow()
    
    init {
        loadProfile()
    }
    
    fun loadProfile() {
        viewModelScope.launch {
            nicheRepository.getCurrentProfile().collect { profile ->
                _uiState.value = if (profile != null) {
                    NicheProfileUiState.Success(profile)
                } else {
                    NicheProfileUiState.Empty
                }
            }
        }
    }
    
    fun saveProfile(niche: String, description: String) {
        viewModelScope.launch {
            val profile = NicheProfile(
                niche = niche,
                description = description
            )
            nicheRepository.createProfile(profile)
            _uiState.value = NicheProfileUiState.Success(profile)
        }
    }
}

sealed class NicheProfileUiState {
    data object Loading : NicheProfileUiState()
    data object Empty : NicheProfileUiState()
    data class Success(val profile: NicheProfile) : NicheProfileUiState()
    data class Error(val message: String) : NicheProfileUiState()
}

// Post Creation ViewModel
@HiltViewModel
class PostCreationViewModel @Inject constructor(
    private val contentGenRepository: ContentGenerationRepository,
    private val postRepository: PinterestPostRepository,
    private val nicheRepository: NicheProfileRepository
) : ViewModel() {
    
    private val _captionState = MutableStateFlow<CaptionState>(CaptionState.Idle)
    val captionState: StateFlow<CaptionState> = _captionState.asStateFlow()
    
    private val _hashtagState = MutableStateFlow<HashtagState>(HashtagState.Idle)
    val hashtagState: StateFlow<HashtagState> = _hashtagState.asStateFlow()
    
    private val _productState = MutableStateFlow<ProductState>(ProductState.Idle)
    val productState: StateFlow<ProductState> = _productState.asStateFlow()

    private val _analysisState = MutableStateFlow<AnalysisState>(AnalysisState.Idle)
    val analysisState: StateFlow<AnalysisState> = _analysisState.asStateFlow()

    private val _boardState = MutableStateFlow<BoardState>(BoardState.Idle)
    val boardState: StateFlow<BoardState> = _boardState.asStateFlow()

    private val _saveState = MutableStateFlow<Boolean>(false)
    val saveState: StateFlow<Boolean> = _saveState.asStateFlow()
    
    fun generateCaptions(description: String) {
        viewModelScope.launch {
            _captionState.value = CaptionState.Loading
            try {
                val profile = nicheRepository.getCurrentProfile().firstOrNull()
                if (profile != null) {
                    val response = contentGenRepository.generateCaptions(description, profile.niche)
                    _captionState.value = CaptionState.Success(response)
                } else {
                    _captionState.value = CaptionState.Error("Please set up your niche profile first")
                }
            } catch (e: Exception) {
                _captionState.value = CaptionState.Error(e.message ?: "Connection error")
            }
        }
    }
    
    fun generateHashtags(content: String) {
        viewModelScope.launch {
            _hashtagState.value = HashtagState.Loading
            try {
                val profile = nicheRepository.getCurrentProfile().firstOrNull()
                if (profile != null) {
                    val response = contentGenRepository.generateHashtags(content, profile.niche)
                    _hashtagState.value = HashtagState.Success(response)
                } else {
                    _hashtagState.value = HashtagState.Error("Please set up your niche profile first")
                }
            } catch (e: Exception) {
                _hashtagState.value = HashtagState.Error(e.message ?: "Connection error")
            }
        }
    }

    fun analyzeImage(imageUri: String) {
        viewModelScope.launch {
            _analysisState.value = AnalysisState.Loading
            delay(1000) // Simulating processing
            try {
                val profile = nicheRepository.getCurrentProfile().firstOrNull()
                val response = contentGenRepository.analyzeImage(imageUri, profile?.niche ?: "General")
                _analysisState.value = AnalysisState.Success(response)
            } catch (e: Exception) {
                _analysisState.value = AnalysisState.Error(e.message ?: "Analysis failed")
            }
        }
    }

    fun suggestBoard(content: String) {
        viewModelScope.launch {
            _boardState.value = BoardState.Loading
            delay(1500) // Convincing AI simulation delay
            try {
                val profile = nicheRepository.getCurrentProfile().firstOrNull()
                val response = contentGenRepository.suggestBoard(content, profile?.niche ?: "General")
                _boardState.value = BoardState.Success(response)
            } catch (e: Exception) {
                _boardState.value = BoardState.Error(e.message ?: "Board suggestion failed")
            }
        }
    }

    fun savePost(
        description: String,
        caption: String,
        hashtags: String,
        imageUri: String,
        boardName: String = "General",
        scheduledTime: Long = System.currentTimeMillis()
    ) {
        viewModelScope.launch {
            val post = PinterestPost(
                imageUri = imageUri,
                description = description,
                captionMinimal = "",
                captionEngaging = caption,
                captionSales = "", 
                hashtags = hashtags,
                productLinks = "", 
                boardName = boardName,
                scheduledTime = scheduledTime,
                isPosted = scheduledTime <= System.currentTimeMillis()
            )
            postRepository.createPost(post)
            _saveState.value = true
        }
    }
}

sealed class CaptionState {
    data object Idle : CaptionState()
    data object Loading : CaptionState()
    data class Success(val data: CaptionResponse) : CaptionState()
    data class Error(val message: String) : CaptionState()
}

sealed class HashtagState {
    data object Idle : HashtagState()
    data object Loading : HashtagState()
    data class Success(val data: HashtagResponse) : HashtagState()
    data class Error(val message: String) : HashtagState()
}

sealed class ProductState {
    data object Idle : ProductState()
    data object Loading : ProductState()
    data class Success(val data: ProductLinksResponse) : ProductState()
    data class Error(val message: String) : ProductState()
}

sealed class AnalysisState {
    data object Idle : AnalysisState()
    data object Loading : AnalysisState()
    data class Success(val data: ImageAnalysisResponse) : AnalysisState()
    data class Error(val message: String) : AnalysisState()
}

sealed class BoardState {
    data object Idle : BoardState()
    data object Loading : BoardState()
    data class Success(val data: BoardResponse) : BoardState()
    data class Error(val message: String) : BoardState()
}

// Analytics ViewModel
@HiltViewModel
class AnalyticsViewModel @Inject constructor(
    private val analyticsRepository: AnalyticsRepository
) : ViewModel() {
    
    private val _analyticsState = MutableStateFlow<List<PostAnalytics>>(emptyList())
    val analyticsState: StateFlow<List<PostAnalytics>> = _analyticsState.asStateFlow()
    
    init {
        loadAnalytics()
    }
    
    fun loadAnalytics() {
        viewModelScope.launch {
            analyticsRepository.getRecentAnalytics().collect { analytics ->
                _analyticsState.value = analytics
            }
        }
    }
}
