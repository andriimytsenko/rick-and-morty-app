package com.rickandmorty.app

import android.app.Application
import coil3.ImageLoader
import coil3.SingletonImageLoader
import org.koin.android.ext.android.inject

class RickAndMortyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        DIConfigurator.configure(this)

        val imageLoader by inject<ImageLoader>()
        SingletonImageLoader.setSafe { _ -> imageLoader }
    }
}