package com.rickandmorty.app.characters.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InfoDto(

    @SerialName("count")
    val count: Int,

    @SerialName("pages")
    val pages: Int,

    @SerialName("next")
    val next: String? = null,

    @SerialName("prev")
    val prev: String? = null
)