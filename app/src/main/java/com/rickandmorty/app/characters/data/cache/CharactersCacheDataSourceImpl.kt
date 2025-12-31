package com.rickandmorty.app.characters.data.cache

import com.rickandmorty.app.characters.data.remote.model.CharacterDto

/* Simple version for cache data source, based on in memory saved data */
class CharactersCacheDataSourceImpl : CharactersCacheDataSource {

    private val cacheData = mutableMapOf<Int, CharacterDto>()

    override fun saveCharacters(characters: List<CharacterDto>) {
        cacheData.putAll(characters.map { it.id to it })
    }

    override fun getCharacterById(id: Int): CharacterDto? {
        return cacheData[id]
    }
}