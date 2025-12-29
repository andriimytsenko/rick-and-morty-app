package com.rickandmorty.app.core.data.repository.model

/**
 * This is a wrapper class to represent repository's data state.
 */
sealed class Resource<out T> {

    /* Repository is loading the data */
    object Loading : Resource<Nothing>()

    /* An error occurs when try to load or modify repository's data */
    data class Error(val exception: Exception) : Resource<Nothing>()

    /* Requested resource are ready */
    data class Success<T>(val data: T) : Resource<T>()

}