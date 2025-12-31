package com.rickandmorty.app.characters.data.cache

import com.rickandmorty.app.characters.data.remote.model.CharacterDto

interface CharactersCacheDataSource {

    fun saveCharacters(characters: List<CharacterDto>)

    fun getCharacterById(id: Int): CharacterDto?
}