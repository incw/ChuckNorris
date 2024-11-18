package dev.smolyakoff.chucknorris.network.di

import dev.smolyakoff.chucknorris.network.ktor.KtorClient
import dev.smolyakoff.chucknorris.network.ktor.KtorClientImpl
import org.koin.dsl.module

val sharedNetworkModule = module {
    single<KtorClient> { KtorClientImpl() }
}
