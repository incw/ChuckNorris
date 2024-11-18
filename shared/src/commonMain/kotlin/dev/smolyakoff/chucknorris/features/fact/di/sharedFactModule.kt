package dev.smolyakoff.chucknorris.features.fact.di

import dev.smolyakoff.chucknorris.features.fact.api.FactsService
import dev.smolyakoff.chucknorris.features.fact.api.FactsServiceImpl
import dev.smolyakoff.chucknorris.features.fact.data.repository.FactsRepositoryImpl
import dev.smolyakoff.chucknorris.features.fact.domain.repository.FactsRepository
import org.koin.dsl.module

val sharedFactModule = module {
    single<FactsService> { FactsServiceImpl(get()) }
    single<FactsRepository> { FactsRepositoryImpl(get(), get()) }
}
