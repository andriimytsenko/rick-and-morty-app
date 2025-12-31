package com.rickandmorty.app.characters.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterDto(

    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String,

    @SerialName("status")
    val status: StatusDto,

    @SerialName("species")
    val species: String,

    @SerialName("gender")
    val gender: GenderDto,

    @SerialName("image")
    val image: String,

    /* Character's origin location */
    @SerialName("origin")
    val origin: LocationDto,

    /* Character's last known location endpoint */
    @SerialName("location")
    val location: LocationDto
)