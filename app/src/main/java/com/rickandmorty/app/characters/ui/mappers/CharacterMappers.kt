package com.rickandmorty.app.characters.ui.mappers

import com.rickandmorty.app.characters.domain.model.Character
import com.rickandmorty.app.characters.ui.browse.model.CharacterUi
import com.rickandmorty.app.characters.ui.profile.model.ProfileUi

/* Map Character domain instance into UI model */
fun Character.toUiModel() = CharacterUi(
    id = id,
    name = name,
    species = species,
    image = image
)

/* Map Character domain instance into Profile model */
fun Character.toProfileUiModel() = ProfileUi(
    name = name,
    status = status,
    species = species,
    gender = gender,
    image = image,
    origin = origin,
    location = location
)