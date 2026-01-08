package com.rickandmorty.app.characters.domain.usecase

import com.rickandmorty.app.characters.data.repository.CharactersRepository
import com.rickandmorty.app.characters.domain.model.Character
import com.rickandmorty.app.core.data.model.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Use case to fetch paging characters for given page.
 */
class GetCharactersUseCase(
    private val charactersRepository: CharactersRepository
) {

    operator fun invoke(page: Int): Flow<Pair<Resource<List<Character>>, Int>> {
        return charactersRepository.getAll(page).map { it to page }
    }
}