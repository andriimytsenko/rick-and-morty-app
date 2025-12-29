package com.rickandmorty.app.characters.data.remote.response

import com.rickandmorty.app.characters.data.remote.consts.DtoKeyName
import com.rickandmorty.app.characters.data.remote.model.CharacterDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharactersResponseDto(

    @SerialName(DtoKeyName.INFO)
    val info: ResponseInfoDto,

    @SerialName(DtoKeyName.RESULTS)
    val results: List<CharacterDto>
)