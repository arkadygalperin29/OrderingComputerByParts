package space.arkady.recyclerhomework

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import space.arkady.recyclerhomework.domain.domain.di.domainModule
import space.arkady.recyclerhomework.presentation.recycler.di.viewModelModule
import space.arkady.recyclerhomework.presentation.recycler.di.viewModelModuleData

class KoinApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@KoinApplication)
            modules(
                listOf(
                    domainModule,
                    viewModelModule,
                    viewModelModuleData
                )
            )
        }
    }
}