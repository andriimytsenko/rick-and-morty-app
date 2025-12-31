package com.rickandmorty.app.characters.domain.model

/**
 * This is Domain layer [com.rickandmorty.app.characters] feature model.
 */
data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val image: String,
    val origin: String,
    val location: String
)