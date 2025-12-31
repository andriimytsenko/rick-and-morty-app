package com.rickandmorty.app.characters.ui.profile

import androidx.compose.runtime.Stable
import com.rickandmorty.app.characters.ui.profile.model.ProfileUi

@Stable
data class ProfileState(
    val profile: ProfileUi,
    val isLoading: Boolean,
    val errorMessage: String?
)