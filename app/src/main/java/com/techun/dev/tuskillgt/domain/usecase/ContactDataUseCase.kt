package com.techun.dev.tuskillgt.domain.usecase

import com.techun.dev.tuskillgt.domain.model.ContactData
import com.techun.dev.tuskillgt.domain.repository.MockAppRepository

class ContactDataUseCase(private val repository: MockAppRepository) {
    suspend operator fun invoke(): ContactData = repository.loadContactInfo()
}