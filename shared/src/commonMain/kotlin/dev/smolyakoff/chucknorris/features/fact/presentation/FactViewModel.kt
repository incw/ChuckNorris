package dev.smolyakoff.chucknorris.features.fact.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.smolyakoff.chucknorris.features.fact.domain.repository.FactsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FactViewModel(
    private val repository: FactsRepository
) : ViewModel() {

    private var timerJob: Job? = null

    private val _viewState = MutableStateFlow<FactViewState>(FactViewState.Loading)
    val viewState = _viewState.asStateFlow()

    init {
        startAutoFetch()
    }

    private suspend fun fetchFact() {

        _viewState.emit(FactViewState.Loading)

        runCatching {
            withContext(Dispatchers.IO) {
                repository.randomFact()
            }
        }
            .onSuccess { _viewState.emit(FactViewState.Success(it)) }
            .onFailure {
                _viewState.emit(FactViewState.Error)
                timerJob?.cancel()
            }

    }

    private fun startAutoFetch() {
        timerJob = viewModelScope.launch {
            while (isActive) {
                fetchFact()
                delay(10_000L)
            }
        }
    }

    fun reFetch() {
        timerJob?.cancel()
        startAutoFetch()
    }

    override fun onCleared() {
        super.onCleared()
        timerJob?.cancel()
    }

}
