package com.rickandmorty.app.characters.ui.profile.model

/**
 * This is UI layer [com.rickandmorty.app.characters] feature model.
 */
data class ProfileUi(
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val image: String,
    val origin: String,
    val location: String
)
