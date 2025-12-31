package com.rickandmorty.app

import android.content.Context
import com.rickandmorty.app.characters.di.charactersFeatureModule
import com.rickandmorty.app.core.di.coreModule
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
                coreModule,
                networkModule,
                /* Feature modules */
                charactersFeatureModule
            )
        }
    }

}