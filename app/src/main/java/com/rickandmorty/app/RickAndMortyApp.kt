package com.rickandmorty.app

import android.app.Application
import coil3.SingletonImageLoader
import com.rickandmorty.app.core.builder.ImageLoaderBuilder
import org.koin.android.ext.android.inject

class RickAndMortyApp : Application() {

    private val imageLoaderBuilder by inject<ImageLoaderBuilder>()

    override fun onCreate() {
        super.onCreate()
        DIConfigurator.configure(this)

        SingletonImageLoader.setSafe { context ->
            imageLoaderBuilder.build(context)
        }
    }

}