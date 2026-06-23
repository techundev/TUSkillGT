package com.techun.dev.tuskillgt.ui.about

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techun.dev.tuskillgt.domain.model.AboutUsData
import com.techun.dev.tuskillgt.domain.usecase.AboutUsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class AboutUiState {
    object Loading : AboutUiState()
    data class Success(val data: AboutUsData) : AboutUiState()
    data class Error(val message: String) : AboutUiState()
}

class AboutViewModel(
    private val aboutUsUseCase: AboutUsUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<AboutUiState>(AboutUiState.Loading)
    val uiState: StateFlow<AboutUiState> = _uiState.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() = viewModelScope.launch {
        runCatching { aboutUsUseCase() }
            .onSuccess { _uiState.value = AboutUiState.Success(it) }
            .onFailure { _uiState.value = AboutUiState.Error(it.message ?: "Error") }
    }
}