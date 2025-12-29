package com.rickandmorty.app.characters.data

import com.rickandmorty.app.characters.data.remote.model.CharacterDto
import com.rickandmorty.app.characters.data.repository.model.Character

/* Map CharacterDto instance into public model */
internal fun CharacterDto.toDomainModel() = Character(
    id = id,
    name = name,
    status = status.name,
    species = species,
    gender = gender.name,
    image = image,
    origin = origin.name,
    location = location.name
)