package com.rickandmorty.app.characters.data.remote.model

import com.rickandmorty.app.characters.data.remote.consts.DtoKeyName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal enum class GenderDto {

    @SerialName(DtoKeyName.Gender.FEMALE)
    FEMALE,

    @SerialName(DtoKeyName.Gender.MALE)
    MALE,

    @SerialName(DtoKeyName.Gender.GENDERLESS)
    GENDERLESS,

    @SerialName(DtoKeyName.Gender.UNKNOWN)
    UNKNOWN
}