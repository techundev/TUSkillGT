package com.techun.dev.tuskillgt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.techun.dev.tuskillgt.core.navigation.AppNavHost
import com.techun.dev.tuskillgt.core.navigation.NavRoutes
import com.techun.dev.tuskillgt.domain.model.SplashDestination
import com.techun.dev.tuskillgt.ui.splash.SplashUiState
import com.techun.dev.tuskillgt.ui.splash.SplashViewModel
import com.techun.dev.tuskillgt.ui.theme.TUSkillGTTheme
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val splashViewModel: SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        var keepSplashOnScreen = true
        splashScreen.setKeepOnScreenCondition { keepSplashOnScreen }

        lifecycleScope.launch {
            splashViewModel.uiState.collect { state ->
                keepSplashOnScreen = state is SplashUiState.Loading
            }
        }

        setContent {
            TUSkillGTTheme {
                val uiState by splashViewModel.uiState.collectAsStateWithLifecycle()

                if (uiState is SplashUiState.Ready) {
                    val destination = (uiState as SplashUiState.Ready).destination
                    AppNavHost(
                        startDestination = when (destination) {
                            SplashDestination.Login -> NavRoutes.Login
                            SplashDestination.Home -> NavRoutes.Main
                        }
                    )

                }
            }
        }
    }
}