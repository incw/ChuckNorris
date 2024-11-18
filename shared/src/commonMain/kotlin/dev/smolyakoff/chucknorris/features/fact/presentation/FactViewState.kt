package dev.smolyakoff.chucknorris.features.fact.presentation

import dev.smolyakoff.chucknorris.features.fact.domain.model.FactModel

sealed class FactViewState {
    data object Loading : FactViewState()
    data object Error: FactViewState()
    data class Success(val fact: FactModel) : FactViewState()
}