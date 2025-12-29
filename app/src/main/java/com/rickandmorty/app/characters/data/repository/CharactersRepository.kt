package com.rickandmorty.app.characters.data.repository

import com.rickandmorty.app.characters.data.repository.model.Character
import com.rickandmorty.app.core.data.repository.model.Resource
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {

    fun getCharacters(page: Int): Flow<Resource<List<Character>>>

}