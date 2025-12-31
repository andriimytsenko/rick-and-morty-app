package com.rickandmorty.app.characters.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LocationDto(

    @SerialName("name")
    val name: String
)