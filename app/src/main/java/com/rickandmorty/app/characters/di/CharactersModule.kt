package com.rickandmorty.app.characters.di

import com.rickandmorty.app.characters.data.local.CharactersLocalDataSource
import com.rickandmorty.app.characters.data.local.CharactersLocalDataSourceImpl
import com.rickandmorty.app.characters.data.remote.CharactersRemoteDataSource
import com.rickandmorty.app.characters.data.remote.CharactersRemoteDataSourceImpl
import com.rickandmorty.app.characters.data.repository.CharactersRepository
import com.rickandmorty.app.characters.data.repository.CharactersRepositoryImpl
import com.rickandmorty.app.characters.domain.usecase.GetCharacterByIdUseCase
import com.rickandmorty.app.characters.domain.usecase.GetCharactersUseCase
import com.rickandmorty.app.characters.ui.browse.BrowseStateFactory
import com.rickandmorty.app.characters.ui.browse.BrowseViewModel
import com.rickandmorty.app.characters.ui.profile.ProfileStateFactory
import com.rickandmorty.app.characters.ui.profile.ProfileViewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

/**
 * This is [com.rickandmorty.app.characters] feature Koin module.
 */
val charactersFeatureModule = module {
    /* DataSources */
    factoryOf(::CharactersRemoteDataSourceImpl) {
        bind<CharactersRemoteDataSource>()
    }
    factoryOf(::CharactersLocalDataSourceImpl) {
        bind<CharactersLocalDataSource>()
    }

    /* Repositories */
    singleOf(::CharactersRepositoryImpl) {
        bind<CharactersRepository>()
    }

    /* UseCases */
    factoryOf(::GetCharactersUseCase)
    factoryOf(::GetCharacterByIdUseCase)

    /* UI StateFactories */
    factoryOf(::BrowseStateFactory)
    factoryOf(::ProfileStateFactory)

    /* ViewModels */
    viewModelOf(::BrowseViewModel)
    viewModelOf(::ProfileViewModel)
}