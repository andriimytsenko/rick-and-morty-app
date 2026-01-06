package com.rickandmorty.app.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rickandmorty.app.characters.data.local.dao.CharacterDao
import com.rickandmorty.app.characters.data.local.entities.CharacterEntity
import com.rickandmorty.app.core.consts.DatabaseConstants

@Database(
    entities = [CharacterEntity::class],
    version = DatabaseConstants.VERSION_1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun charactersDao(): CharacterDao
}