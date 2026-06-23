package com.techun.dev.tuskillgt.ui.competencies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techun.dev.tuskillgt.domain.model.CompetenciesData
import com.techun.dev.tuskillgt.domain.usecase.CompetenciesDataUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class CompetenciesUiState {
    object Loading : CompetenciesUiState()
    data class Success(val data: List<CompetenciesData>) : CompetenciesUiState()
    data class Error(val message: String) : CompetenciesUiState()
}

class CompetenciesViewModel(private val competenciesDataUseCase: CompetenciesDataUseCase) :
    ViewModel() {
    private val _uiState = MutableStateFlow<CompetenciesUiState>(CompetenciesUiState.Loading)
    val uiState: StateFlow<CompetenciesUiState> = _uiState.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() = viewModelScope.launch {
        runCatching { competenciesDataUseCase() }
            .onSuccess { _uiState.value = CompetenciesUiState.Success(it) }
            .onFailure { _uiState.value = CompetenciesUiState.Error(it.message ?: "Error") }
    }
}