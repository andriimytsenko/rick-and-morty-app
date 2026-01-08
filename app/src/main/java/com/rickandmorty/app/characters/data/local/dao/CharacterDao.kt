package com.rickandmorty.app.characters.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rickandmorty.app.characters.data.local.entities.CharacterEntity

@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg characters: CharacterEntity)

    @Query("SELECT * FROM characters LIMIT :limit OFFSET :offset")
    suspend fun getAll(limit: Int, offset: Int): List<CharacterEntity>

    @Query("SELECT * FROM characters WHERE id IN (:id) LIMIT 1")
    suspend fun getById(id: Int): CharacterEntity?
}