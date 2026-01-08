package com.rickandmorty.app.characters.ui.browse

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.rickandmorty.app.R
import com.rickandmorty.app.characters.ui.components.CharacterItem
import com.rickandmorty.app.characters.ui.browse.model.CharacterUi
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
        characters = state.characters,
        isEmpty = state.isEmpty,
        isLoading = state.isLoading,
        isError = state.isError,
        listState = listState,
        onCharacterClick = navigateToProfile,
        onRetryClick = { viewModel.handleEvent(OnRetryLoadContent)}
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
    characters: List<CharacterUi>,
    modifier: Modifier = Modifier,
    isEmpty: Boolean = true,
    isLoading: Boolean = false,
    isError: Boolean = false,
    listState: LazyListState = rememberLazyListState(),
    onCharacterClick: (Int) -> Unit = {},
    onRetryClick: () -> Unit = {}
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        when {
            isLoading -> LoadingStateWidget(
                modifier = Modifier.fillMaxWidth()
            )
            isError -> ErrorStateWidget(
                text = stringResource(R.string.oops_error_occurs_when_loading_data),
                modifier = Modifier.fillMaxWidth(),
                retry = onRetryClick
            )
        }

        if (isEmpty) {
            EmptyStateWidget(
                modifier = Modifier.fillMaxWidth()
            )
        } else {
            CharactersList(
                items = characters,
                modifier = Modifier.fillMaxWidth(),
                state = listState,
                onClick = onCharacterClick
            )
        }
    }
}

@Composable
private fun LoadingStateWidget(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CircularProgressIndicator()
        Text(
            text = stringResource(R.string.loading),
            modifier = Modifier
                .padding(
                    horizontal = 12.dp,
                    vertical = 4.dp
                )
        )
    }
}

@Composable
private fun EmptyStateWidget(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(56.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.oops_no_characters_found_yet),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun ErrorStateWidget(
    text: String,
    modifier: Modifier = Modifier,
    retry: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = text)
        Button(onClick = retry) {
            Text(text = stringResource(R.string.button_retry))
        }
    }
}

@Composable
private fun CharactersList(
    items: List<CharacterUi>,
    modifier: Modifier = Modifier,
    state: LazyListState = rememberLazyListState(),
    onClick: (Int) -> Unit = {}
) {
    LazyColumn(
        state = state,
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(
            items = items,
            key = { it.id }
        ) { character ->
            CharacterItem(
                modifier = Modifier
                    .clickable(onClick = {
                        onClick(character.id)
                    })
                    .padding(horizontal = 16.dp),
                name = character.name,
                species = character.species,
                image = character.image
            )
        }
    }
}

/* Preview area */
@Preview(showBackground = true)
@Composable
private fun BrowseEmptyStatePreview() {
    RickAndMortyTheme {
        BrowseContent(
            characters = listOf(),
            isEmpty = true,
            isLoading = true
        )
    }
}