package dev.smolyakoff.chucknorris.features.history.domain

import dev.smolyakoff.chucknorris.features.fact.domain.model.FactModel

interface HistoryRepository {

    @Throws(Throwable::class)
    suspend fun history(): List<FactModel>

}
