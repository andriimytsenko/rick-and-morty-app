package com.rickandmorty.app.characters.ui.browse

import androidx.compose.runtime.Stable
import com.rickandmorty.app.characters.ui.browse.model.CharacterUi

@Stable
data class BrowseState(
    val isLoading: Boolean,
    val page: Int,
    val hasMore: Boolean,
    val characters: List<CharacterUi>,
    val errorMessage: String?
) {
    val isEmpty: Boolean
        get() = !isLoading && characters.isEmpty()

    val isError: Boolean
        get() = errorMessage != null
}