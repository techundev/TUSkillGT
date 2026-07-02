package com.techun.dev.tuskillgt.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techun.dev.tuskillgt.domain.model.SplashDestination
import com.techun.dev.tuskillgt.domain.usecase.GetSplashDestinationUseCase
import com.techun.dev.tuskillgt.domain.usecase.InitializeDefaultUserUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class SplashUiState {
    data object Loading : SplashUiState()
    data class Ready(val destination: SplashDestination) : SplashUiState()
}

class SplashViewModel(
    private val initializeDefaultUserUseCase: InitializeDefaultUserUseCase,
    private val getSplashDestinationUseCase: GetSplashDestinationUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<SplashUiState>(SplashUiState.Loading)
    val uiState: StateFlow<SplashUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            initializeDefaultUserUseCase()
            val destination = getSplashDestinationUseCase()
            _uiState.value = SplashUiState.Ready(destination)
        }
    }
}