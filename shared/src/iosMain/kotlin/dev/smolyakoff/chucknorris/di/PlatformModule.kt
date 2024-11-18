package dev.smolyakoff.chucknorris.di

import dev.smolyakoff.chucknorris.features.fact.presentation.FactViewModel
import dev.smolyakoff.chucknorris.features.history.presentation.HistoryViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.dsl.module

actual fun getPlatform() = module {
    single { FactViewModel(get()) }
    single { HistoryViewModel(get()) }
}

object GetViewModels: KoinComponent {
    fun getFactsViewModel() = get<FactViewModel>()
    fun getHistoryViewModel() = get<HistoryViewModel>()
}
