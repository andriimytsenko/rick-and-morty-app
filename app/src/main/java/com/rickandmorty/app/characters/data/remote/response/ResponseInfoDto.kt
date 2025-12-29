package com.rickandmorty.app.characters.data.remote.response

import com.rickandmorty.app.characters.data.remote.consts.DtoKeyName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseInfoDto(

    @SerialName(DtoKeyName.COUNT)
    val count: Int,

    @SerialName(DtoKeyName.PAGES)
    val pages: Int,

    @SerialName(DtoKeyName.NEXT)
    val next: String? = null,

    @SerialName(DtoKeyName.PREV)
    val prev: String? = null
)