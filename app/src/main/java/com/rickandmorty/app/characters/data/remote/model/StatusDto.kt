package com.rickandmorty.app.characters.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class StatusDto {

    @SerialName("Alive")
    ALIVE,

    @SerialName("Dead")
    DEAD,

    @SerialName("unknown")
    UNKNOWN
}