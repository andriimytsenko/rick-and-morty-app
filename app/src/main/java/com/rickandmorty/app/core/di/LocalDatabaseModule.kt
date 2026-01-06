package com.rickandmorty.app.core.di

import androidx.room.Room
import com.rickandmorty.app.characters.data.local.dao.CharacterDao
import com.rickandmorty.app.core.consts.DatabaseConstants
import com.rickandmorty.app.core.data.local.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * This is local App database module.
 */
val localDatabaseModule = module {
    single<AppDatabase> {
        Room.databaseBuilder(
            context = androidContext(),
            klass = AppDatabase::class.java,
            name = DatabaseConstants.NAME
        )
            .fallbackToDestructiveMigration(true)
            .build()
    }

    factory<CharacterDao> {
        val database = get<AppDatabase>()
        database.charactersDao()
    }
}