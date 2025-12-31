package com.rickandmorty.app.core.data.model

/**
 * This is a wrapper class for loadable data with state handle.
 */
sealed class Resource<out T> {

    open val errorMessage: String? = null

    /* Repository is loading resources */
    object Loading : Resource<Nothing>()

    /* An error occurs when try to load or modify repository's resource */
    data class Error(val exception: Exception) : Resource<Nothing>() {

        override val errorMessage: String?
            get() = exception.localizedMessage
    }

    /* Requested resource are ready */
    data class Success<T>(val data: T) : Resource<T>()

}