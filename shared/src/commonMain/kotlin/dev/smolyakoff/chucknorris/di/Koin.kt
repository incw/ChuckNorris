package dev.smolyakoff.chucknorris.di

import dev.smolyakoff.chucknorris.database.di.sharedDatabaseModule
import dev.smolyakoff.chucknorris.features.fact.di.sharedFactModule
import dev.smolyakoff.chucknorris.features.history.di.sharedHistoryModule
import dev.smolyakoff.chucknorris.network.di.sharedNetworkModule
import org.koin.core.context.startKoin

fun initKoin() = startKoin {
    modules(
        sharedNetworkModule,
        sharedDatabaseModule(),
        sharedFactModule,
        sharedHistoryModule,
        getPlatform(),
    )
}
