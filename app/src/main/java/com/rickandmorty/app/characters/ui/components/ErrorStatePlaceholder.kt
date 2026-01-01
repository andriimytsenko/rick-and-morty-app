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
fun ErrorStatePlaceholder(
    message: String?,
    modifier: Modifier = Modifier,
    reloadContent: () -> Unit = {}
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = message ?: stringResource(R.string.something_went_wrong),
            textAlign = TextAlign.Center
        )
        Button(onClick = reloadContent) {
            Text(text = stringResource(R.string.button_try_again))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ErrorStatePreview() {
    RickAndMortyTheme {
        ErrorStatePlaceholder(message = "Something go wrong!")
    }
}
