package com.rickandmorty.app.characters.ui.browse

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.rickandmorty.app.characters.ui.components.CharacterItem
import com.rickandmorty.app.characters.ui.browse.model.CharacterUi
import com.rickandmorty.app.characters.ui.components.EmptyStatePlaceholder
import com.rickandmorty.app.characters.ui.components.ErrorStatePlaceholder
import com.rickandmorty.app.core.consts.CommonConstants
import com.rickandmorty.app.core.ui.theme.RickAndMortyTheme

/* Screen area */
@Composable
fun BrowseScreen(
    viewModel: BrowseViewModel,
    navigateToProfile: (Int) -> Unit
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    val listState = rememberLazyListState()

    BrowseContent(
        state = state,
        listState = listState,
        reloadContent = { viewModel.handleEvent(OnReloadContent) },
        navigateToProfile = navigateToProfile
    )

    LaunchedEffect(listState.canScrollForward) {
        if (!listState.canScrollForward) {
            viewModel.handleEvent(OnScrollToEndOfContent)
        }
    }
}

/* Content area */
@Composable
private fun BrowseContent(
    state: BrowseState,
    listState: LazyListState = rememberLazyListState(),
    reloadContent: () -> Unit = {},
    navigateToProfile: (Int) -> Unit = {}
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when {
            state.isError -> {
                ErrorStatePlaceholder(
                    message = state.errorMessage,
                    reloadContent = reloadContent
                )
            }
            state.isEmpty -> {
                EmptyStatePlaceholder(reloadContent = reloadContent)
            }
            else -> {
                /* Characters Column */
                LazyColumn(
                    state = listState,
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.align(Alignment.TopCenter)
                ) {
                    items(state.characters) { character ->
                        CharacterItem(
                            modifier = Modifier
                                .clickable(onClick = {
                                    navigateToProfile(character.id)
                                })
                                .padding(horizontal = 16.dp),
                            name = character.name,
                            species = character.species,
                            image = character.image
                        )
                    }
                }
                if (state.isLoading) {
                    CircularProgressIndicator()
                }
            }
        }
    }
}

/* Preview area */
@Preview(showBackground = true)
@Composable
private fun BrowsePreview() {
    RickAndMortyTheme {
        BrowseContent(
            state = BrowseState(
                page = CommonConstants.PAGE_1,
                characters = listOf(
                    CharacterUi(
                        id = 1,
                        name = "Rick Sanchez",
                        species = "Human",
                        image = ""
                    ),
                    CharacterUi(
                        id = 1,
                        name = "Rick Sanchez",
                        species = "Human",
                        image = ""
                    ),
                    CharacterUi(
                        id = 1,
                        name = "Rick Sanchez",
                        species = "Human",
                        image = ""
                    )
                ),
                isLoading = false,
                hasMore = true,
                errorMessage = null
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun BrowseEmptyStatePreview() {
    RickAndMortyTheme {
        BrowseContent(
            state = BrowseState(
                page = CommonConstants.PAGE_1,
                characters = listOf(),
                isLoading = false,
                hasMore = true,
                errorMessage = null
            )
        )
    }
}