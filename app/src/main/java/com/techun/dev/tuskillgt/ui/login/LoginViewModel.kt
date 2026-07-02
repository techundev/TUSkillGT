package com.techun.dev.tuskillgt.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techun.dev.tuskillgt.domain.model.LoginResult
import com.techun.dev.tuskillgt.domain.usecase.AuthUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class LoginUiState {
    object Idle : LoginUiState()
    object Loading : LoginUiState()
    object Success : LoginUiState()
    data class Error(val message: String) : LoginUiState()
}

class LoginViewModel(private val authUseCase: AuthUseCase) : ViewModel() {
    private val _uiState = MutableStateFlow<LoginUiState>(LoginUiState.Idle)
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun login(user: String, password: String) = viewModelScope.launch {
        _uiState.value = LoginUiState.Loading
        _uiState.value = when (val result = authUseCase(user, password)) {
            is LoginResult.Success -> LoginUiState.Success
            is LoginResult.InvalidCredentials -> LoginUiState.Error("Usuario o contraseña incorrectos")
            is LoginResult.Error -> LoginUiState.Error(result.message)
        }
    }
}
