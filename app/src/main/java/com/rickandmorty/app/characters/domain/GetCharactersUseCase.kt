package com.rickandmorty.app.characters.domain

import com.rickandmorty.app.characters.data.repository.CharactersRepository
import com.rickandmorty.app.characters.data.repository.model.Character
import com.rickandmorty.app.core.data.repository.model.Resource
import kotlinx.coroutines.flow.Flow

class GetCharactersUseCase(
    private val charactersRepository: CharactersRepository
) {

    operator fun invoke(page: Int): Flow<Resource<List<Character>>> {
        return charactersRepository.getCharacters(page)
    }
}