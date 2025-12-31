package com.rickandmorty.app.core.ui.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

/* Global app navigation routes */
sealed interface NavRoute : NavKey

@Serializable
data object BrowseRoute : NavRoute

@Serializable
data class ProfileRoute(val id: Int) : NavRoute