package dev.smolyakoff.chucknorris.di

import dev.smolyakoff.chucknorris.features.fact.presentation.FactViewModel
import dev.smolyakoff.chucknorris.features.history.presentation.HistoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

actual fun getPlatform() = module {
    viewModel { FactViewModel(get()) }
    viewModel { HistoryViewModel(get()) }
}
