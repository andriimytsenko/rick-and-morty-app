package com.rickandmorty.app.characters.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.rickandmorty.app.core.ui.theme.RickAndMortyTheme

@Composable
fun ProfileTextSection(
    title: String,
    text: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Text(
            text = title,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 22.sp
        )
        Text(
            text = text,
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 16.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProfileTextSectionPreview() {
    RickAndMortyTheme {
        ProfileTextSection(
            title = "Location",
            text = "Earth"
        )
    }
}