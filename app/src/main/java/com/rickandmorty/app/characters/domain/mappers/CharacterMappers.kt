package com.rickandmorty.app.characters.domain.mappers

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