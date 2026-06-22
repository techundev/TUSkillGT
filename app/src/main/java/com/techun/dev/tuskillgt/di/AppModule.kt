package com.techun.dev.tuskillgt.di

import com.techun.dev.tuskillgt.data.repository.HomeRepositoryImpl
import com.techun.dev.tuskillgt.domain.repository.HomeRepository
import com.techun.dev.tuskillgt.domain.usecase.HomeDataUseCase
import com.techun.dev.tuskillgt.ui.home.HomeViewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appDataModule = module {
    singleOf(::HomeRepositoryImpl) { bind<HomeRepository>() }
}

val appDomainModule = module {
    factoryOf(::HomeDataUseCase)
}

val appUiModule = module {
    viewModelOf(::HomeViewModel)
}