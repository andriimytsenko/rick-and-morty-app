package com.rickandmorty.app.core.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rickandmorty.app.core.ui.main.components.NavigationRoot
import com.rickandmorty.app.core.ui.theme.RickAndMortyTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyTheme {
                Scaffold { padding ->
                    MainActivityContent(modifier = Modifier.padding(padding))
                }
            }
        }
    }
}

/* Content area */
@Composable
private fun MainActivityContent(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        NavigationRoot()
    }
}

/* Preview area */
@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun MainActivityPreview() {
    RickAndMortyTheme(darkTheme = true) {
        Scaffold { padding ->
            MainActivityContent(modifier = Modifier.padding(padding))
        }
    }
}