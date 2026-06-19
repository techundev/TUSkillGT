package com.techun.dev.tuskillgt.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.techun.dev.tuskillgt.core.utils.back
import com.techun.dev.tuskillgt.ui.AboutScreen
import com.techun.dev.tuskillgt.ui.CompetenciesScreen
import com.techun.dev.tuskillgt.ui.ContactScreen
import com.techun.dev.tuskillgt.ui.HomeScreen

@Composable
fun NavigationWrapper(
    backStack: NavBackStack<NavKey>,
    modifier: Modifier = Modifier
) {
    NavDisplay(
        backStack = backStack,
        modifier = modifier,
        onBack = {
            backStack.back()
        },
        entryProvider = entryProvider {
            entry<NavRoutes.Home> {
                HomeScreen()
            }
            entry<NavRoutes.About> {
                AboutScreen()
            }
            entry<NavRoutes.Competencies> {
                CompetenciesScreen()
            }
            entry<NavRoutes.Contact> {
                ContactScreen()
            }
        }
    )
}