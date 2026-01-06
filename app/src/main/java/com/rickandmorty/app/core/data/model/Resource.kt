package com.rickandmorty.app.core.data.model

/**
 * This is a wrapper class for loadable data to represent it in different state.
 */
sealed class Resource<out T> {

    open val errorMessage: String? = null

    /* Resource are loading */
    object Loading : Resource<Nothing>()

    /* State when An error occurs */
    data class Error(val exception: Exception) : Resource<Nothing>() {

        override val errorMessage: String?
            get() = exception.localizedMessage
    }

    /* Requested resource are ready to use */
    data class Ready<T>(val data: T) : Resource<T>()
}