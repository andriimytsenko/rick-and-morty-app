package com.rickandmorty.app.core.di

import com.rickandmorty.app.core.data.remote.HttpClientConfigurator
import com.rickandmorty.app.core.ui.main.MainViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

/**
 * This is a [com.rickandmorty.app.core] DI Koin module.
 */
val coreModule = module {
    /* Ktor HttpClient */
    single { HttpClientConfigurator.configure() }

    /* MainViewModel */
    viewModel<MainViewModel> { MainViewModel() }
}