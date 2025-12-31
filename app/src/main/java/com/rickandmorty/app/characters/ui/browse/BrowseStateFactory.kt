package com.rickandmorty.app.characters.ui.browse

import com.rickandmorty.app.characters.domain.model.Character
import com.rickandmorty.app.characters.ui.mappers.toUiModel
import com.rickandmorty.app.core.consts.CommonConstants
import com.rickandmorty.app.core.data.model.Resource

class BrowseStateFactory {

    /* Create a default state */
    fun create() = BrowseState(
        isLoading = true,
        page = CommonConstants.PAGE_1,
        hasMore = false,
        characters = emptyList(),
        errorMessage = null
    )

    /* Update state with new data */
    fun createWith(
        state: BrowseState,
        resource: Resource<List<Character>>,
        page: Int,
        refresh: Boolean
    ): BrowseState {
        var hasMore = true
        val characters = if (resource is Resource.Success) {
            val pageCharacters = resource.data.map { it.toUiModel() }
            hasMore = pageCharacters.any()
            /* Replace or add page characters to state base on refresh flag */
            if (refresh) pageCharacters else state.characters.plus(pageCharacters)
        } else {
            /* Characters do not loaded yet */
            state.characters
        }
        return state.copy(
            isLoading = resource == Resource.Loading,
            page = page,
            hasMore = hasMore,
            characters = characters,
            errorMessage = resource.errorMessage
        )
    }
}