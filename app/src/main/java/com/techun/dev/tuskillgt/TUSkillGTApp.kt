package com.techun.dev.tuskillgt

import android.app.Application
import com.techun.dev.tuskillgt.di.appDataModule
import com.techun.dev.tuskillgt.di.appDomainModule
import com.techun.dev.tuskillgt.di.appUiModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class TUSkillGTApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@TUSkillGTApp)
            modules(
                appDataModule,
                appDomainModule,
                appUiModule
            )
        }
    }
}