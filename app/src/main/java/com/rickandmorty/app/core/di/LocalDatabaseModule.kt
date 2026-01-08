package com.rickandmorty.app.core.di

import androidx.room.Room
import com.rickandmorty.app.characters.data.local.dao.CharacterDao
import com.rickandmorty.app.core.data.local.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/* File private constants area */
private const val DATABASE_NAME = "rick_and_morty_db"

/* Koin module area */
val localDatabaseModule = module {
    single<AppDatabase> {
        Room.databaseBuilder(
            context = androidContext(),
            klass = AppDatabase::class.java,
            name = DATABASE_NAME
        )
            .fallbackToDestructiveMigration(true)
            .build()
    }

    /* Dao area */
    factory<CharacterDao> {
        val database = get<AppDatabase>()
        database.charactersDao()
    }
}