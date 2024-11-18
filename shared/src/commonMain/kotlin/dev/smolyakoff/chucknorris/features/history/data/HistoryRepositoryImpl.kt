package dev.smolyakoff.chucknorris.features.history.data

import dev.smolyakoff.chucknorris.features.fact.data.mappers.toModel
import dev.smolyakoff.chucknorris.features.fact.domain.model.FactModel
import dev.smolyakoff.chucknorris.features.history.domain.HistoryRepository
import dev.smolyakoff.chucknorris.features.history.local.HistoryDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class HistoryRepositoryImpl(
    private val dao: HistoryDao
) : HistoryRepository {


    @Throws(Throwable::class)
    override suspend fun history(): List<FactModel> {
        return dao.factsAsFlow()
            .map { items ->
                items.toModel()
            }
    }

}