package com.rickandmorty.app.characters.data.remote

import com.rickandmorty.app.characters.data.remote.consts.CharactersApi
import com.rickandmorty.app.characters.data.remote.response.CharactersResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

internal class CharactersRemoteDataSource(
    private val httpClient: HttpClient
) {

    suspend fun getCharacters(page: Int): CharactersResponse {
        val response = httpClient.get(CharactersApi.Route.CHARACTER) {
            parameter(CharactersApi.Query.PAGE, page)
        }
        return response.body<CharactersResponse>()
    }
}