package com.techun.dev.tuskillgt.domain.model

sealed class SplashDestination {
    data object Login : SplashDestination()
    data object Home : SplashDestination()
}
