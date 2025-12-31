package com.rickandmorty.app.core.ui.main.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.rickandmorty.app.characters.ui.browse.BrowseScreen
import com.rickandmorty.app.characters.ui.profile.ProfileScreen
import com.rickandmorty.app.core.ui.navigation.BrowseRoute
import com.rickandmorty.app.core.ui.navigation.ProfileRoute
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parameterSetOf

@Composable
fun NavigationRoot(modifier: Modifier = Modifier) {
    val navBackStack = rememberNavBackStack(BrowseRoute)

    NavDisplay(
        backStack = navBackStack,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider {
            /* Browse screen */
            entry<BrowseRoute> { route ->
                BrowseScreen(
                    viewModel = koinViewModel(),
                    navigateToProfile = { id -> navBackStack.add(ProfileRoute(id)) })
            }
            /* Profile screen */
            entry<ProfileRoute> { route ->
                ProfileScreen(
                    viewModel = koinViewModel(
                        parameters = { parameterSetOf(route.id) }
                    ),
                    navigateBack = { navBackStack.removeLastOrNull() }
                )
            }
        },
        modifier = modifier
    )
}