package com.techun.dev.tuskillgt.di

import androidx.room.Room
import com.techun.dev.tuskillgt.data.local.database.AuthDatabase
import com.techun.dev.tuskillgt.data.local.preferences.AppPreferencesDataSource
import com.techun.dev.tuskillgt.data.repository.MockAppRepositoryImpl
import com.techun.dev.tuskillgt.data.repository.AuthRepositoryImpl
import com.techun.dev.tuskillgt.domain.repository.MockAppRepository
import com.techun.dev.tuskillgt.domain.repository.AuthRepository
import com.techun.dev.tuskillgt.domain.usecase.AboutUsUseCase
import com.techun.dev.tuskillgt.domain.usecase.LoginUseCase
import com.techun.dev.tuskillgt.domain.usecase.CompetenciesDataUseCase
import com.techun.dev.tuskillgt.domain.usecase.ContactDataUseCase
import com.techun.dev.tuskillgt.domain.usecase.GetSplashDestinationUseCase
import com.techun.dev.tuskillgt.domain.usecase.HomeDataUseCase
import com.techun.dev.tuskillgt.domain.usecase.InitializeDefaultUserUseCase
import com.techun.dev.tuskillgt.domain.usecase.LogoutUseCase
import com.techun.dev.tuskillgt.ui.about.AboutViewModel
import com.techun.dev.tuskillgt.ui.competencies.CompetenciesViewModel
import com.techun.dev.tuskillgt.ui.contact.ContactViewModel
import com.techun.dev.tuskillgt.ui.home.HomeViewModel
import com.techun.dev.tuskillgt.ui.login.LoginViewModel
import com.techun.dev.tuskillgt.ui.splash.SplashViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

private const val AUTH_DATABASE = "auth_database"

val roomModule = module {
    single {
        Room.databaseBuilder(
            context = androidContext(), klass = AuthDatabase::class.java, name = AUTH_DATABASE
        ).fallbackToDestructiveMigration(false).build()
    }

    single { get<AuthDatabase>().authDao() }
}

val dataStoreModule = module {
    single { AppPreferencesDataSource(androidContext()) }
}

val appDataModule = module {
    singleOf(::MockAppRepositoryImpl) { bind<MockAppRepository>() }
    singleOf(::AuthRepositoryImpl) { bind<AuthRepository>() }
}

val appDomainModule = module {
    factoryOf(::HomeDataUseCase)
    factoryOf(::AboutUsUseCase)
    factoryOf(::CompetenciesDataUseCase)
    factoryOf(::ContactDataUseCase)
    factoryOf(::InitializeDefaultUserUseCase)
    factoryOf(::LoginUseCase)
    factoryOf(::LogoutUseCase)
    factoryOf(::GetSplashDestinationUseCase)
}

val appUiModule = module {
    viewModelOf(::HomeViewModel)
    viewModelOf(::AboutViewModel)
    viewModelOf(::CompetenciesViewModel)
    viewModelOf(::ContactViewModel)
    viewModelOf(::LoginViewModel)
    viewModelOf(::SplashViewModel)
}