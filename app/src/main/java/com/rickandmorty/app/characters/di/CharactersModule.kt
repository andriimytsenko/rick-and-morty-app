package com.rickandmorty.app.characters.di

import com.rickandmorty.app.characters.data.remote.CharactersRemoteDataSource
import com.rickandmorty.app.characters.data.repository.CharactersRepository
import com.rickandmorty.app.characters.data.repository.CharactersRepositoryImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

/**
 * This is [com.rickandmorty.app.characters] feature scoped Koin module.
 */
val charactersModule = module {
    /* Characters remote DataSource */
    factoryOf(::CharactersRemoteDataSource)

    /* Characters repository */
    factoryOf(::CharactersRepositoryImpl) {
        bind<CharactersRepository>()
    }
}