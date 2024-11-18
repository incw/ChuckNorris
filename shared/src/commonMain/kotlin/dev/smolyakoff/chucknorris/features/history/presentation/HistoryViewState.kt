package dev.smolyakoff.chucknorris.features.history.presentation

import dev.smolyakoff.chucknorris.features.fact.domain.model.FactModel

sealed class HistoryViewState {

    data object Loading : HistoryViewState()

    data object Empty : HistoryViewState()

    data class Success(val items: List<FactModel>) : HistoryViewState()

}