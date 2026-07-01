package com.techun.dev.tuskillgt.domain.repository

import com.techun.dev.tuskillgt.domain.model.AboutUsData
import com.techun.dev.tuskillgt.domain.model.CompetenciesData
import com.techun.dev.tuskillgt.domain.model.ContactData
import com.techun.dev.tuskillgt.domain.model.HomeData
import com.techun.dev.tuskillgt.domain.model.User

interface MockAppRepository {
    suspend fun loadHomeInfo(): HomeData
    suspend fun loadAboutUsInfo(): AboutUsData
    suspend fun loadCompetenciesInfo(): List<CompetenciesData>
    suspend fun loadContactInfo(): ContactData
}