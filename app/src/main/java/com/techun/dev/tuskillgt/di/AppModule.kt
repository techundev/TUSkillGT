package com.techun.dev.tuskillgt.di

import com.techun.dev.tuskillgt.data.repository.MockAppRepositoryImpl
import com.techun.dev.tuskillgt.domain.repository.MockAppRepository
import com.techun.dev.tuskillgt.domain.usecase.AboutUsUseCase
import com.techun.dev.tuskillgt.domain.usecase.CompetenciesDataUseCase
import com.techun.dev.tuskillgt.domain.usecase.ContactDataUseCase
import com.techun.dev.tuskillgt.domain.usecase.HomeDataUseCase
import com.techun.dev.tuskillgt.ui.about.AboutViewModel
import com.techun.dev.tuskillgt.ui.competencies.CompetenciesViewModel
import com.techun.dev.tuskillgt.ui.contact.ContactViewModel
import com.techun.dev.tuskillgt.ui.home.HomeViewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appDataModule = module {
    singleOf(::MockAppRepositoryImpl) { bind<MockAppRepository>() }
}

val appDomainModule = module {
    factoryOf(::HomeDataUseCase)
    factoryOf(::AboutUsUseCase)
    factoryOf(::CompetenciesDataUseCase)
    factoryOf(::ContactDataUseCase)
}

val appUiModule = module {
    viewModelOf(::HomeViewModel)
    viewModelOf(::AboutViewModel)
    viewModelOf(::CompetenciesViewModel)
    viewModelOf(::ContactViewModel)
}