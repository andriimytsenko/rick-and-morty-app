package com.rickandmorty.app.characters.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.rickandmorty.app.core.ui.theme.RickAndMortyTheme

@Composable
fun ProfileHeader(
    image: String,
    name: String,
    species: String,
    status: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        AsyncImage(
            model = image,
            contentDescription = name,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            SubHeaderText(
                name = name,
                species = species,
                modifier = Modifier.weight(1f)
            )
            StatusLabel(status = status)
        }
    }
}

@Composable
private fun SubHeaderText(
    name: String,
    species: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = name,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 24.sp
        )
        Text(
            text = species,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 20.sp
        )
    }
}

@Composable
private fun StatusLabel(
    status: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = status,
        fontSize = 12.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 20.sp,
        modifier = modifier
            .background(
                color = Color.LightGray,
                shape = RoundedCornerShape(4.dp)
            )
            .padding(4.dp)
    )
}

@Preview(showBackground = true)
@Composable
private fun ProfileHeaderPreview() {
    RickAndMortyTheme {
        ProfileHeader(
            image = "",
            name = "Rick Sanchez",
            species = "Human",
            status = "Alive"
        )
    }
}