package com.rickandmorty.app.characters.data.remote.response

import com.rickandmorty.app.characters.data.remote.consts.DtoKeyName
import com.rickandmorty.app.characters.data.remote.model.CharacterDto
import com.rickandmorty.app.characters.data.remote.model.InfoDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class CharactersResponse(

    @SerialName(DtoKeyName.INFO)
    val info: InfoDto,

    @SerialName(DtoKeyName.RESULTS)
    val results: List<CharacterDto>
)