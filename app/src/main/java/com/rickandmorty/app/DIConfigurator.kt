package com.rickandmorty.app

import android.content.Context
import com.rickandmorty.app.characters.di.charactersFeatureModule
import com.rickandmorty.app.core.di.imageLoaderModule
import com.rickandmorty.app.core.di.localDatabaseModule
import com.rickandmorty.app.core.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * This class is a start point to configure DI in the app.
 */
object DIConfigurator {

    fun configure(context: Context) {
        startKoin {
            androidContext(context)
            modules(
                /* Core modules */
                networkModule,
                imageLoaderModule,
                localDatabaseModule,
                /* Feature modules */
                charactersFeatureModule
            )
        }
    }

}