package com.mohylev.news

import androidx.lifecycle.ViewModel
import com.mohylev.news.models.Article
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

internal class NewsViewModel : ViewModel() {

    private val _state = MutableStateFlow<NewsState>(NewsState.None)
    val state: StateFlow<NewsState>
        get() = _state.asStateFlow()

}

internal sealed class NewsState {
    data object None : NewsState()
    data object Loading: NewsState()
    data object Error : NewsState()
    data class Success (val articles : List<Article>) : NewsState()
}