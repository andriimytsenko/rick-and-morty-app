package com.rickandmorty.app.characters.ui.browse

sealed interface BrowseEvent

data object OnScrollToEndOfContent : BrowseEvent

data object OnReloadContent : BrowseEvent