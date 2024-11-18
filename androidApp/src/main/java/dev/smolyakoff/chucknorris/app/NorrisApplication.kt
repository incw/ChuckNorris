package dev.smolyakoff.chucknorris.app

import android.app.Application
import dev.smolyakoff.chucknorris.database.di.sharedDatabaseModule
import dev.smolyakoff.chucknorris.di.getPlatform
import dev.smolyakoff.chucknorris.features.fact.di.sharedFactModule
import dev.smolyakoff.chucknorris.features.history.di.sharedHistoryModule
import dev.smolyakoff.chucknorris.network.di.sharedNetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NorrisApplication : Application() {


    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@NorrisApplication)
            modules(
                sharedNetworkModule,
                sharedDatabaseModule(),
                sharedFactModule,
                getPlatform(),
                sharedHistoryModule
            )
        }
    }

}