package com.rickandmorty.app.characters.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rickandmorty.app.characters.domain.usecase.GetCharacterByIdUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val stateFactory: ProfileStateFactory,
    private val getCharacterByIdUseCase: GetCharacterByIdUseCase,
    private val id: Int
) : ViewModel() {

    private val _uiState = MutableStateFlow(stateFactory.create())
    val uiState: StateFlow<ProfileState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            getCharacterByIdUseCase(id).collect { resource ->
                _uiState.update { state -> stateFactory.createWith(state, resource) }
            }
        }
    }
}