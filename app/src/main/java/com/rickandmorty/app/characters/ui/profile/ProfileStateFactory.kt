package com.rickandmorty.app.characters.ui.profile

import com.rickandmorty.app.characters.domain.model.Character
import com.rickandmorty.app.characters.ui.mappers.toProfileUiModel
import com.rickandmorty.app.characters.ui.profile.model.ProfileUi
import com.rickandmorty.app.core.data.model.Resource

class ProfileStateFactory {

    /* Create a default state */
    fun create() = ProfileState(
        profile = ProfileUi(
            name = "",
            status = "",
            species = "",
            gender = "",
            image = "",
            origin = "",
            location = ""
        ),
        isLoading = false,
        errorMessage = null
    )

    /* Update state with new data */
    fun createWith(
        state: ProfileState,
        resource: Resource<Character>
    ): ProfileState {
        val profile = if (resource is Resource.Ready<Character>) {
            resource.data.toProfileUiModel()
        } else {
            state.profile
        }
        return state.copy(
            profile = profile,
            isLoading = resource == Resource.Loading,
            errorMessage = resource.errorMessage
        )
    }
}