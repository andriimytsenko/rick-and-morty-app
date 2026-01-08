package com.rickandmorty.app.core.di

import coil3.ImageLoader
import coil3.disk.DiskCache
import coil3.memory.MemoryCache
import coil3.network.ktor3.KtorNetworkFetcherFactory
import coil3.request.crossfade
import coil3.disk.directory
import io.ktor.client.HttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/* File private constants area */
private const val MEMORY_CACHE_MAX_SIZE = 0.25 // 25%
private const val DISK_CACHE_MAX_SIZE = 0.05 // 5%

private const val DISK_CACHE_FOLDER = "image_cache"

/* Koin module area */
val imageLoaderModule = module {
    single<ImageLoader> {
        val context = androidContext()
        ImageLoader.Builder(context)
            .memoryCache {
                MemoryCache.Builder()
                    .maxSizePercent(context, MEMORY_CACHE_MAX_SIZE)
                    .build()
            }
            .diskCache {
                DiskCache.Builder()
                    .directory(context.cacheDir.resolve(DISK_CACHE_FOLDER))
                    .maxSizePercent(DISK_CACHE_MAX_SIZE)
                    .build()
            }
            .components {
                add(KtorNetworkFetcherFactory(get<HttpClient>()))
            }
            .crossfade(true)
            .build()
    }
}