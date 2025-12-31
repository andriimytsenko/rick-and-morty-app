package com.rickandmorty.app.characters.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class GenderDto {

    @SerialName("Female")
    FEMALE,

    @SerialName("Male")
    MALE,

    @SerialName("Genderless")
    GENDERLESS,

    @SerialName("unknown")
    UNKNOWN
}