package com.rickandmorty.app.characters.data.remote

import com.rickandmorty.app.characters.data.remote.model.CharacterDto

interface CharactersRemoteDataSource {

    suspend fun getCharacters(page: Int): List<CharacterDto>
}