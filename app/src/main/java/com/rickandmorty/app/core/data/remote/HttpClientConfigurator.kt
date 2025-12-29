package com.rickandmorty.app.core.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

/**
 * Core configurator for HttpClient instance.
 */
object HttpClientConfigurator {

    fun configure(baseUrl: String = NetworkConstants.BASE_URL) = HttpClient(Android) {
        /* Json serialization settings */
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                explicitNulls = false
            })
        }

        /* Timeout settings */
        install(HttpTimeout) {
            requestTimeoutMillis = NetworkConstants.Timeout.REQUEST_TIMEOUT_MILLIS
            connectTimeoutMillis = NetworkConstants.Timeout.CONNECT_TIMEOUT_MILLIS
        }

        /* Default request settings */
        defaultRequest {
            url(baseUrl)
        }
    }
}