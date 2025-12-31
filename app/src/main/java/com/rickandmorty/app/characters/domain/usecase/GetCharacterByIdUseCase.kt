package com.rickandmorty.app.characters.domain.usecase

import com.rickandmorty.app.characters.data.repository.CharactersRepository
import com.rickandmorty.app.characters.domain.model.Character
import com.rickandmorty.app.core.data.model.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Use case to fetch character details by id.
 */
class GetCharacterByIdUseCase(
    private val charactersRepository: CharactersRepository
) {

    operator fun invoke(id: Int): Flow<Resource<Character>> {
        return charactersRepository.getCharacterById(id)
    }
}