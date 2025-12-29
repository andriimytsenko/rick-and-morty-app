package com.rickandmorty.app.characters.di

import com.rickandmorty.app.characters.data.remote.CharactersRemoteDataSource
import com.rickandmorty.app.characters.data.repository.CharactersRepository
import com.rickandmorty.app.characters.data.repository.CharactersRepositoryImpl
import com.rickandmorty.app.characters.domain.GetCharactersUseCase
import com.rickandmorty.app.characters.ui.browse.BrowseCharactersViewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

/**
 * This is [com.rickandmorty.app.characters] feature scoped Koin module.
 */
val charactersFeatureModule = module {
    /* Remote DataSources */
    factoryOf(::CharactersRemoteDataSource)

    /* Repositories */
    singleOf(::CharactersRepositoryImpl) {
        bind<CharactersRepository>()
    }

    /* UseCases */
    factoryOf(::GetCharactersUseCase)

    /* ViewModels */
    viewModelOf(::BrowseCharactersViewModel)
}