package com.rickandmorty.app.characters.data.repository

import com.rickandmorty.app.characters.data.local.CharactersLocalDataSource
import com.rickandmorty.app.characters.data.mappers.toLocalModel
import com.rickandmorty.app.characters.domain.mappers.toDomainModel
import com.rickandmorty.app.characters.data.remote.CharactersRemoteDataSource
import com.rickandmorty.app.core.data.model.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

internal class CharactersRepositoryImpl(
    private val remoteDataSource: CharactersRemoteDataSource,
    private val localDataSource: CharactersLocalDataSource
) : CharactersRepository {

    override fun getCharacters(page: Int) = flow {
        try {
            /* Fetch data from local source */
            localDataSource.getAll(page).also { localData ->
                emit(Resource.Success(localData.map { it.toDomainModel() }))
            }
            emit(Resource.Loading)
            /* Fetch data from remote source and save it locally */
            remoteDataSource.getCharacters(page).also { remoteData ->
                localDataSource.save(*remoteData.map { it.toLocalModel() }.toTypedArray())
                emit(Resource.Success(remoteData.map { it.toDomainModel() }))
            }
        } catch (ex: Exception) {
            emit(Resource.Error(ex))
        }
    }.flowOn(Dispatchers.IO)

    override fun getCharacterById(id: Int) = flow {
        when (val character = localDataSource.getById(id)) {
            null -> emit(Resource.Error(Exception("No saved details")))
            else -> emit(Resource.Success(character.toDomainModel()))
        }
    }.flowOn(Dispatchers.IO)
}