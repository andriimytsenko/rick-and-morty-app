package com.rickandmorty.app.characters.data.local

import com.rickandmorty.app.characters.data.local.entities.CharacterEntity

interface CharactersLocalDataSource {

    suspend fun save(vararg characters: CharacterEntity)

    suspend fun getAll(page: Int): List<CharacterEntity>

    suspend fun getById(id: Int): CharacterEntity?
}