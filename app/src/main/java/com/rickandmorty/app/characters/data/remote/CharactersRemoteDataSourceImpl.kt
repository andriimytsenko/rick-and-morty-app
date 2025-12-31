package com.rickandmorty.app.characters.data.remote

import com.rickandmorty.app.characters.data.remote.model.CharacterDto
import com.rickandmorty.app.characters.data.remote.response.CharactersResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.appendPathSegments

internal class CharactersRemoteDataSourceImpl(
    private val httpClient: HttpClient
) : CharactersRemoteDataSource {

    override suspend fun getCharacters(page: Int): List<CharacterDto> {
        val response = httpClient.get {
            url {
                appendPathSegments("character")
                parameter("page", page)
            }
        }
        return response.body<CharactersResponse>().results
    }
}