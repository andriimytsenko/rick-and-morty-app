package com.rickandmorty.app.characters.data.repository

import com.rickandmorty.app.characters.data.remote.CharactersRemoteDataSource
import com.rickandmorty.app.characters.data.toDomainModel
import com.rickandmorty.app.core.data.repository.model.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

internal class CharactersRepositoryImpl(
    private val remoteDataSource: CharactersRemoteDataSource
) : CharactersRepository {

    override fun getCharacters(page: Int) = flow {
        emit(Resource.Loading)
        try {
            val response = remoteDataSource.getCharacters(page)
            val result = response.results.map { it.toDomainModel() }
            emit(Resource.Success(result))
        } catch (ex: Exception) {
            emit(Resource.Error(ex))
        }
    }.flowOn(Dispatchers.IO)
}