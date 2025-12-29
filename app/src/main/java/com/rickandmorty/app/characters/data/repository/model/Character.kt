package com.rickandmorty.app.characters.data.repository.model

/**
 * This is public [com.rickandmorty.app.characters] feature scoped model.
 */
data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val image: String,

    /* Character's origin location */
    val origin: String,

    /* Character's last known location endpoint */
    val location: String
)