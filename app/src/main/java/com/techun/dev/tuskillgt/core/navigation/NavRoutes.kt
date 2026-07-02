package com.techun.dev.tuskillgt.core.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class NavRoutes : NavKey {
    @Serializable
    data object Login : NavRoutes()

    @Serializable
    data object Home : NavRoutes()

    @Serializable
    data object About : NavRoutes()

    @Serializable
    data object Competencies : NavRoutes()

    @Serializable
    data object Contact : NavRoutes()
}