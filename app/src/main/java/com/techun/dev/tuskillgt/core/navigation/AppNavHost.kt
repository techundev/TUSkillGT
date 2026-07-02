package com.techun.dev.tuskillgt.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.techun.dev.tuskillgt.core.utils.back
import com.techun.dev.tuskillgt.ui.login.LoginScreen
import com.techun.dev.tuskillgt.ui.main.MainScreen

@Composable
fun AppNavHost(
    startDestination: NavRoutes,
    modifier: Modifier = Modifier
) {
    val rootBackStack = rememberNavBackStack(startDestination)

    NavDisplay(
        backStack = rootBackStack,
        modifier = modifier,
        onBack = { rootBackStack.back() },
        entryProvider = entryProvider {
            entry<NavRoutes.Login> {
                LoginScreen(
                    onLoginSuccess = {
                        rootBackStack.clear()
                        rootBackStack.add(NavRoutes.Main)
                    }
                )
            }
            entry<NavRoutes.Main> {
                MainScreen()
            }
        }
    )
}