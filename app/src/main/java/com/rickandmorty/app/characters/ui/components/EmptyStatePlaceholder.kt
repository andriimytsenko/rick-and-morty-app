package com.rickandmorty.app.characters.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.rickandmorty.app.R
import com.rickandmorty.app.core.ui.theme.RickAndMortyTheme

@Composable
fun EmptyStatePlaceholder(
    modifier: Modifier = Modifier,
    reloadContent: () -> Unit = {}
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.none_result_found),
            textAlign = TextAlign.Center
        )
        Button(onClick = reloadContent) {
            Text(text = stringResource(R.string.button_refresh))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun EmptyStatePreview() {
    RickAndMortyTheme { EmptyStatePlaceholder() }
}