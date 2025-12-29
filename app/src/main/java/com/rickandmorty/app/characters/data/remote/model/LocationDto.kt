package com.rickandmorty.app.characters.data.remote.model

import com.rickandmorty.app.characters.data.remote.consts.DtoKeyName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class LocationDto(

    @SerialName(DtoKeyName.NAME)
    val name: String
)