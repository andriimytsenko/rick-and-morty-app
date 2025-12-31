package com.rickandmorty.app.characters.data.remote.response

import com.rickandmorty.app.characters.data.remote.model.CharacterDto
import com.rickandmorty.app.characters.data.remote.model.InfoDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharactersResponse(

    @SerialName("info")
    val info: InfoDto,

    @SerialName("results")
    val results: List<CharacterDto>
)