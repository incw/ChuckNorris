package dev.smolyakoff.chucknorris.features.history.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.smolyakoff.chucknorris.features.history.domain.HistoryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HistoryViewModel(
    private val repository: HistoryRepository
) : ViewModel() {

    private val _viewState = MutableStateFlow<HistoryViewState>(HistoryViewState.Loading)
    val viewState = _viewState.asStateFlow()

    fun fetchHistory() {
        viewModelScope.launch {
            runCatching { repository.history() }
                .onSuccess { cached ->
                    if (cached.isEmpty()) {
                        _viewState.emit(HistoryViewState.Empty)
                    } else {
                        _viewState.emit(HistoryViewState.Success(cached))
                    }
                }
        }
    }

}
