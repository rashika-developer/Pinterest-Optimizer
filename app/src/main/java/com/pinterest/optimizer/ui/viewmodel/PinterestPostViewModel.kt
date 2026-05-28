package com.pinterest.optimizer.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pinterest.optimizer.data.models.PinterestPost
import com.pinterest.optimizer.data.repository.PinterestPostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class PinterestPostViewModel @Inject constructor(
    private val repository: PinterestPostRepository
) : ViewModel() {

    val allPosts: StateFlow<List<PinterestPost>> = repository.getAllPosts()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )
}
