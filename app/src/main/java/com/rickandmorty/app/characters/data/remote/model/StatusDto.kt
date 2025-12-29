package com.rickandmorty.app.characters.data.remote.model

import com.rickandmorty.app.characters.data.remote.consts.DtoKeyName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal enum class StatusDto {

    @SerialName(DtoKeyName.Status.ALIVE)
    ALIVE,

    @SerialName(DtoKeyName.Status.DEAD)
    DEAD,

    @SerialName(DtoKeyName.Status.UNKNOWN)
    UNKNOWN
}