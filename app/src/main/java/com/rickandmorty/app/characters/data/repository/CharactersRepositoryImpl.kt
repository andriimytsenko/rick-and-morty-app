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

    override fun getAll(page: Int) = flow {
        try {
            localDataSource.getAll(page).also { localData ->
                emit(Resource.Ready(localData.map { it.toDomainModel() }))
            }
            emit(Resource.Loading)
            remoteDataSource.getAll(page).also { remoteData ->
                localDataSource.update(*remoteData.map { it.toLocalModel() }.toTypedArray())
                emit(Resource.Ready(remoteData.map { it.toDomainModel() }))
            }
        } catch (ex: Exception) {
            emit(Resource.Error(ex))
        }
    }.flowOn(Dispatchers.IO)

    override fun getById(id: Int) = flow {
        try {
            localDataSource.getById(id)?.let { localData ->
                emit(Resource.Ready(localData.toDomainModel()))
                // We could be sure that local data source contains all
                // available details about character. If none records found
                // for given id try to fetch details from remote source
                return@flow
            }
            emit(Resource.Loading)
            remoteDataSource.getById(id).let { remoteData ->
                localDataSource.update(remoteData.toLocalModel())
                emit(Resource.Ready(remoteData.toDomainModel()))
            }
        } catch (ex: Exception) {
            emit(Resource.Error(ex))
        }
    }.flowOn(Dispatchers.IO)
}