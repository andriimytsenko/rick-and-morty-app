package com.rickandmorty.app.core.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rickandmorty.app.core.ui.theme.AppTheme

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text("Hello! This is Rick and Morty App")
    }
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    AppTheme { MainScreen() }
}
