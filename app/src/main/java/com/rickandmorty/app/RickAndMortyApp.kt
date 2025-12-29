package com.rickandmorty.app

import android.app.Application

class RickAndMortyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        DIConfigurator.configure(this)
    }

}