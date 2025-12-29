package com.rickandmorty.app.characters.data.remote.consts

/**
 * This is [com.rickandmorty.app.characters] feature scoped JSON keys.
 */
internal object DtoKeyName {

    /* Common mapping keys */
    const val ID = "id"
    const val NAME = "name"
    const val STATUS = "status"
    const val SPECIES = "species"
    const val GENDER = "gender"
    const val ORIGIN = "origin"
    const val LOCATION = "location"
    const val IMAGE = "image"
    const val INFO = "info"
    const val COUNT = "count"
    const val PAGES = "pages"
    const val NEXT = "next"
    const val PREV = "prev"
    const val RESULTS = "results"

    /* StatusDto enum mapping keys */
    internal object Status {
        const val ALIVE = "Alive"
        const val DEAD = "Dead"
        const val UNKNOWN = "unknown"
    }

    /* GenderDto enum mapping keys */
    internal object Gender {
        const val FEMALE = "Female"
        const val MALE = "Male"
        const val GENDERLESS = "Genderless"
        const val UNKNOWN = "unknown"
    }
}