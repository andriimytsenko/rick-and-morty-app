package com.rickandmorty.app.characters.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.rickandmorty.app.core.ui.theme.RickAndMortyTheme

@Composable
fun CharacterItem(
    name: String,
    species: String,
    image: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        AsyncImage(
            model = image,
            contentDescription = name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = name,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                lineHeight = 22.sp
            )
            Text(
                text = species,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                lineHeight = 20.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CharacterItemPreview() {
    RickAndMortyTheme {
        CharacterItem(
            name = "Rick Sanchez",
            species = "Human",
            image = ""
        )
    }
}