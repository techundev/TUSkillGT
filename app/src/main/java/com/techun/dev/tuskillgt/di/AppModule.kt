package com.techun.dev.tuskillgt.di

import com.techun.dev.tuskillgt.data.repository.MockAppRepositoryImpl
import com.techun.dev.tuskillgt.domain.repository.MockAppRepository
import com.techun.dev.tuskillgt.domain.usecase.AboutUsUseCase
import com.techun.dev.tuskillgt.domain.usecase.HomeDataUseCase
import com.techun.dev.tuskillgt.ui.about.AboutViewModel
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
}

val appUiModule = module {
    viewModelOf(::HomeViewModel)
    viewModelOf(::AboutViewModel)
}