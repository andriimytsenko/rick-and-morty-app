package com.rickandmorty.app.characters.data.local

import com.rickandmorty.app.characters.consts.CharactersFeatureConstants
import com.rickandmorty.app.characters.data.local.dao.CharacterDao
import com.rickandmorty.app.characters.data.local.entities.CharacterEntity

class CharactersLocalDataSourceImpl(
    private val charactersDao: CharacterDao
) : CharactersLocalDataSource {

    override suspend fun update(vararg characters: CharacterEntity) {
        charactersDao.insert(*characters)
    }

    override suspend fun getAll(page: Int): List<CharacterEntity> {
        val limit = CharactersFeatureConstants.PAGE_SIZE
        val offset = page * CharactersFeatureConstants.PAGE_SIZE
        return charactersDao.getAll(limit = limit, offset = offset)
    }

    override suspend fun getById(id: Int): CharacterEntity? {
        return charactersDao.getById(id)
    }
}