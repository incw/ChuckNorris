package dev.smolyakoff.chucknorris.features.history.di

import dev.smolyakoff.chucknorris.features.history.data.HistoryRepositoryImpl
import dev.smolyakoff.chucknorris.features.history.domain.HistoryRepository
import org.koin.dsl.module

val sharedHistoryModule = module {
    single<HistoryRepository> { HistoryRepositoryImpl(get()) }
}
