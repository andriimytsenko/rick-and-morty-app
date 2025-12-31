package com.rickandmorty.app.core.di

import com.rickandmorty.app.core.builder.ImageLoaderBuilder
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

/**
 * This is a [com.rickandmorty.app.core] core DI Koin module.
 */
val coreModule = module {
    /* ImageLoader builder */
    factoryOf(::ImageLoaderBuilder)
}