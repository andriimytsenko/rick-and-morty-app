package com.rickandmorty.app.characters.ui.browse

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rickandmorty.app.characters.domain.usecase.GetCharactersUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class BrowseViewModel(
    private val stateFactory: BrowseStateFactory,
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(stateFactory.create())
    val uiState: StateFlow<BrowseState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            val page = uiState.value.page
            getCharacters(page)
        }
    }

    fun handleEvent(event: BrowseEvent) {
        when (event) {
            /* Load more content if has */
            is OnScrollToEndOfContent -> {
                if (uiState.value.hasMore) {
                    viewModelScope.launch {
                        val nextPage = uiState.value.page.inc()
                        getCharacters(nextPage)
                    }
                }
            }
            /* Try to reload last page content */
            is OnRetryLoadContent -> {
                viewModelScope.launch {
                    val page = uiState.value.page
                    getCharacters(page)
                }
            }
        }
    }

    private suspend fun getCharacters(page: Int) {
        getCharactersUseCase(page).collect { data ->
            _uiState.update { state ->
                val resource = data.first
                val page = data.second
                stateFactory.createWith(state, resource, page)
            }
        }
    }
}