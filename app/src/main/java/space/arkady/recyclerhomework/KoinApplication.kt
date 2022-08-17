package space.arkady.recyclerhomework

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import space.arkady.recyclerhomework.domain.di.domainModule
import space.arkady.recyclerhomework.presentation.di.viewModelModule

class KoinApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@KoinApplication)
            modules(
                listOf(
                    domainModule,
                    viewModelModule,
                )
            )
        }
    }
}