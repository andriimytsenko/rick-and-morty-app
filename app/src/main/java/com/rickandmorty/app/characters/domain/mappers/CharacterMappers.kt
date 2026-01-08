package com.rickandmorty.app.characters.domain.mappers

import com.rickandmorty.app.characters.data.local.entities.CharacterEntity
import com.rickandmorty.app.characters.data.remote.model.CharacterDto
import com.rickandmorty.app.characters.domain.model.Character

/* Map CharacterDto instance into domain model */
fun CharacterDto.toDomainModel() = Character(
    id = id,
    name = name,
    status = status.name,
    species = species,
    gender = gender.name,
    image = image,
    origin = origin.name,
    location = location.name
)

/* Map CharacterEntity instance into domain model */
fun CharacterEntity.toDomainModel() = Character(
    id = id,
    name = name,
    status = status,
    species = species,
    gender = gender,
    image = image,
    origin = origin,
    location = location
)