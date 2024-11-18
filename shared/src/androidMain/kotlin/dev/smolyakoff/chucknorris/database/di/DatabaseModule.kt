package dev.smolyakoff.chucknorris.database.di

import dev.smolyakoff.chucknorris.database.room.FactsDatabase
import dev.smolyakoff.chucknorris.database.room.getFactsDatabase
import dev.smolyakoff.chucknorris.features.fact.local.FactsDao
import dev.smolyakoff.chucknorris.features.history.local.HistoryDao
import org.koin.dsl.module

actual fun sharedDatabaseModule() = module {
    single<FactsDatabase> { getFactsDatabase(get()) }
    single<FactsDao> { getFactsDatabase(get()).factsDao() }
    single<HistoryDao> { getFactsDatabase(get()).historyDao() }
}