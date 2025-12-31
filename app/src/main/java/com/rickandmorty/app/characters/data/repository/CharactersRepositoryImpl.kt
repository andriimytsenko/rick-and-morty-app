package com.rickandmorty.app.characters.data.repository

import com.rickandmorty.app.characters.data.cache.CharactersCacheDataSource
import com.rickandmorty.app.characters.domain.mappers.toDomainModel
import com.rickandmorty.app.characters.data.remote.CharactersRemoteDataSource
import com.rickandmorty.app.core.data.model.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

internal class CharactersRepositoryImpl(
    private val remoteDataSource: CharactersRemoteDataSource,
    private val cacheDataSource: CharactersCacheDataSource
) : CharactersRepository {

    override fun getCharacters(page: Int) = flow {
        emit(Resource.Loading)
        try {
            val remoteData = remoteDataSource.getCharacters(page).also {
                cacheDataSource.saveCharacters(it)
            }
            val characters = remoteData.map { it.toDomainModel() }
            emit(Resource.Success(characters))
        } catch (ex: Exception) {
            emit(Resource.Error(ex))
        }
    }.flowOn(Dispatchers.IO)

    override fun getCharacterById(id: Int) = flow {
        when (val character = cacheDataSource.getCharacterById(id)) {
            null -> emit(Resource.Error(Exception("Cache is empty")))
            else -> emit(Resource.Success(character.toDomainModel()))
        }
    }.flowOn(Dispatchers.IO)
}