package com.techun.dev.tuskillgt.ui.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.rememberNavBackStack
import com.techun.dev.tuskillgt.core.navigation.NavRoutes
import com.techun.dev.tuskillgt.core.navigation.NavigationWrapper
import com.techun.dev.tuskillgt.core.utils.backTo
import com.techun.dev.tuskillgt.core.utils.navigateTo
import com.techun.dev.tuskillgt.ui.main.composables.TUSkillGTAppBottomBar

@Composable
fun MainScreen(onLogout: () -> Unit) {
    val backStack = rememberNavBackStack(NavRoutes.Home)
    val currentRoute = backStack.last()

    Scaffold(
        bottomBar = {
            TUSkillGTAppBottomBar(
                currentRout = currentRoute,
                onItemSeleted = { route ->
                    if (currentRoute != route) {
                        if (route in backStack) {
                            backStack.backTo(route)
                        } else {
                            backStack.navigateTo(route)
                        }
                    }
                })
        }) { innerPadding ->
        NavigationWrapper(
            backStack = backStack,
            onLogout = onLogout,
            modifier = Modifier.padding(innerPadding)
        )
    }
}