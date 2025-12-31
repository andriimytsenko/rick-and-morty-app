package com.rickandmorty.app.characters.data.repository

import com.rickandmorty.app.characters.domain.model.Character
import com.rickandmorty.app.core.data.model.Resource
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {

    fun getCharacters(page: Int): Flow<Resource<List<Character>>>

    fun getCharacterById(id: Int): Flow<Resource<Character>>
}