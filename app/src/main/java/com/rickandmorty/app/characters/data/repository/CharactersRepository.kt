package com.rickandmorty.app.characters.data.repository

import com.rickandmorty.app.characters.domain.model.Character
import com.rickandmorty.app.core.data.model.Resource
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {

    fun getAll(page: Int): Flow<Resource<List<Character>>>

    fun getById(id: Int): Flow<Resource<Character>>
}