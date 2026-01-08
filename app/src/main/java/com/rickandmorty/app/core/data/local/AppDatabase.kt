package com.rickandmorty.app.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rickandmorty.app.characters.data.local.dao.CharacterDao
import com.rickandmorty.app.characters.data.local.entities.CharacterEntity

/* App database version constants area */
private const val VERSION_1 = 1

@Database(
    entities = [CharacterEntity::class],
    version = VERSION_1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun charactersDao(): CharacterDao
}