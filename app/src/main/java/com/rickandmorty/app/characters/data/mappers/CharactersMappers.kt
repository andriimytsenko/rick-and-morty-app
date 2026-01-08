package com.rickandmorty.app.characters.data.mappers

import com.rickandmorty.app.characters.data.local.entities.CharacterEntity
import com.rickandmorty.app.characters.data.remote.model.CharacterDto

/* Map CharacterDto instance into local database model */
fun CharacterDto.toLocalModel() = CharacterEntity(
    id = id,
    name = name,
    status = status.name,
    species = species,
    gender = gender.name,
    image = image,
    origin = origin.name,
    location = location.name
)