package com.rickandmorty.app.characters.ui.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.rickandmorty.app.R
import com.rickandmorty.app.characters.ui.profile.components.ProfileHeader
import com.rickandmorty.app.characters.ui.profile.components.ProfileTextSection
import com.rickandmorty.app.characters.ui.profile.model.ProfileUi
import com.rickandmorty.app.core.ui.theme.RickAndMortyTheme

/* Screen area */
@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel,
    navigateBack: () -> Unit
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    ProfileContent(state, navigateBack)
}

/* Content area */
@Composable
private fun ProfileContent(
    state: ProfileState,
    onBackClick: () -> Unit = {}
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        ProfileHeader(
            image = state.profile.image,
            name = state.profile.name,
            species = state.profile.species,
            status = state.profile.status
        )
        ProfileTextSection(
            title = stringResource(R.string.gender),
            text = state.profile.gender
        )
        ProfileTextSection(
            title = stringResource(R.string.location),
            text = state.profile.location
        )
        ProfileTextSection(
            title = stringResource(R.string.origin),
            text = state.profile.origin
        )
        Button(onClick = onBackClick) {
            Text(text = stringResource(R.string.button_back))
        }
    }
}

/* Preview area */
@Preview(showBackground = true)
@Composable
private fun ProfilePreview() {
    RickAndMortyTheme {
        ProfileContent(
            ProfileState(
                profile = ProfileUi(
                    name = "Rick Sanchez",
                    image = "",
                    status = "Alive",
                    species = "Human",
                    gender = "Male",
                    origin = "Earth",
                    location = "Earth"
                ),
                isLoading = false,
                errorMessage = null
            )
        )
    }
}