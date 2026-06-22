package com.techun.dev.tuskillgt.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techun.dev.tuskillgt.domain.model.DataHome
import com.techun.dev.tuskillgt.domain.usecase.HomeDataUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class HomeUiState {
    object Loading : HomeUiState()
    data class Success(val data: DataHome) : HomeUiState()
    data class Error(val message: String) : HomeUiState()
}

class HomeViewModel(
    private val homeDataUseCase: HomeDataUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() = viewModelScope.launch {
        runCatching { homeDataUseCase() }
            .onSuccess { _uiState.value = HomeUiState.Success(it) }
            .onFailure { _uiState.value = HomeUiState.Error(it.message ?: "Errror") }
    }
}