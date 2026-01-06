package com.rickandmorty.app.core.di

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

/* File private constants area */
private const val BASE_URL = "https://rickandmortyapi.com/api/"

private const val REQUEST_TIMEOUT_MILLIS = 5000L // 5 seconds
private const val CONNECT_TIMEOUT_MILLIS = 5000L // 5 seconds

/* Koin module area */
val networkModule = module {
    single<HttpClient> {
        HttpClient(Android) {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    explicitNulls = false
                })
            }
            install(HttpTimeout) {
                requestTimeoutMillis = REQUEST_TIMEOUT_MILLIS
                connectTimeoutMillis = CONNECT_TIMEOUT_MILLIS
            }
            defaultRequest {
                url(BASE_URL)
            }

            /* Interceptors area */
            // Add any interceptors here if need
        }
    }
}