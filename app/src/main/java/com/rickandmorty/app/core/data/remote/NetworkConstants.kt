package com.rickandmorty.app.core.data.remote

/**
 * This is general network settings constants.
 */
object NetworkConstants {

    const val BASE_URL = "https://rickandmortyapi.com/api"

    object Timeout {
        const val REQUEST_TIMEOUT_MILLIS = 5000L // 5 seconds
        const val CONNECT_TIMEOUT_MILLIS = 5000L // 5 seconds
    }
}