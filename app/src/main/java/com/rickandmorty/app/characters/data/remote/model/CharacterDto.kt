package com.rickandmorty.app.characters.data.remote.model

import com.rickandmorty.app.characters.data.remote.consts.DtoKeyName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class CharacterDto(

    @SerialName(DtoKeyName.ID)
    val id: Int,

    @SerialName(DtoKeyName.NAME)
    val name: String,

    @SerialName(DtoKeyName.STATUS)
    val status: StatusDto,

    @SerialName(DtoKeyName.SPECIES)
    val species: String,

    @SerialName(DtoKeyName.GENDER)
    val gender: GenderDto,

    @SerialName(DtoKeyName.IMAGE)
    val image: String,

    /* Character's origin location */
    @SerialName(DtoKeyName.ORIGIN)
    val origin: LocationDto,

    /* Character's last known location endpoint */
    @SerialName(DtoKeyName.LOCATION)
    val location: LocationDto
)