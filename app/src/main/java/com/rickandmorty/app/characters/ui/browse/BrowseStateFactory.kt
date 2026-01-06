package com.rickandmorty.app.characters.ui.browse

import com.rickandmorty.app.characters.domain.model.Character
import com.rickandmorty.app.characters.ui.browse.model.CharacterUi
import com.rickandmorty.app.characters.ui.mappers.toUiModel
import com.rickandmorty.app.core.consts.CommonConstants
import com.rickandmorty.app.core.data.model.Resource
import kotlin.collections.putAll

class BrowseStateFactory {

    /* Create an initial state */
    fun create() = BrowseState(
        isLoading = false,
        page = CommonConstants.PAGE_1,
        hasMore = false,
        characters = emptyList(),
        errorMessage = null
    )

    /* Update state with new data */
    fun createWith(
        state: BrowseState,
        resource: Resource<List<Character>>,
        page: Int
    ): BrowseState {
        var hasMore = true
        val characters = if (resource is Resource.Ready) {
            val pageData = resource.data.map { it.toUiModel() }
            hasMore = pageData.any()
            buildCharactersList(state, page, pageData)
        } else {
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

    private fun buildCharactersList(
        state: BrowseState,
        page: Int,
        pageData: List<CharacterUi>
    ): List<CharacterUi> {
        return when {
            page > state.page -> state.characters.plus(pageData)
            else -> mergeCharactersData(state.characters, pageData)
        }
    }

    private fun mergeCharactersData(
        stateData: List<CharacterUi>,
        other: List<CharacterUi>
    ): List<CharacterUi> {
        val dataMap = buildMap {
            putAll(stateData.map { it.id to it })
            putAll(other.map { it.id to it })
        }
        return dataMap.values.toList()
    }
}