package com.rickandmorty.app.characters.ui.browse

import androidx.lifecycle.ViewModel
import com.rickandmorty.app.characters.domain.GetCharactersUseCase

class BrowseCharactersViewModel(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {
}