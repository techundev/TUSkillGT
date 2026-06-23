package com.techun.dev.tuskillgt.ui.contact

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techun.dev.tuskillgt.domain.model.ContactData
import com.techun.dev.tuskillgt.domain.usecase.ContactDataUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class ContactUiState {
    object Loading : ContactUiState()
    data class Success(val data: ContactData) : ContactUiState()
    data class Error(val message: String) : ContactUiState()
}

class ContactViewModel(private val contactDataUseCase: ContactDataUseCase) : ViewModel() {
    private val _uiState = MutableStateFlow<ContactUiState>(ContactUiState.Loading)
    val uiState: StateFlow<ContactUiState> = _uiState.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() = viewModelScope.launch {
        runCatching { contactDataUseCase() }
            .onSuccess { _uiState.value = ContactUiState.Success(it) }
            .onFailure { _uiState.value = ContactUiState.Error(it.message ?: "Error") }
    }
}