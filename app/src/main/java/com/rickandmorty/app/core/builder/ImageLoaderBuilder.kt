package com.rickandmorty.app.core.builder

import android.content.Context
import coil3.ImageLoader
import coil3.disk.DiskCache
import coil3.disk.directory
import coil3.memory.MemoryCache
import coil3.network.ktor3.KtorNetworkFetcherFactory
import coil3.request.crossfade
import com.rickandmorty.app.core.consts.ImageLoaderConstants
import io.ktor.client.HttpClient

/**
 * This is where core ImageLoader could be configure.
 */
class ImageLoaderBuilder(
    private val httpClient: HttpClient
) {

    fun build(context: Context) = ImageLoader.Builder(context)
        .memoryCache {
            MemoryCache.Builder()
                .maxSizePercent(context, ImageLoaderConstants.MEMORY_CACHE_MAX_SIZE)
                .build()
        }
        .diskCache {
            DiskCache.Builder()
                .directory(context.cacheDir.resolve(ImageLoaderConstants.DISK_CACHE_FOLDER))
                .maxSizePercent(ImageLoaderConstants.DISK_CACHE_MAX_SIZE)
                .build()
        }
        .components {
            add(KtorNetworkFetcherFactory(httpClient))
        }
        .crossfade(true)
        .build()
}