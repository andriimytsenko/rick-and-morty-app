package com.rickandmorty.app.characters.data.remote

import com.rickandmorty.app.characters.data.remote.model.CharacterDto

interface CharactersRemoteDataSource {

    suspend fun getAll(page: Int): List<CharacterDto>

    suspend fun getById(id: Int): CharacterDto
}