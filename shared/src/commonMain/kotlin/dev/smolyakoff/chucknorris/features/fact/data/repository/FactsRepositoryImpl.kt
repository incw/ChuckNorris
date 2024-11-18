package dev.smolyakoff.chucknorris.features.fact.data.repository

import dev.smolyakoff.chucknorris.features.fact.api.FactsService
import dev.smolyakoff.chucknorris.features.fact.data.mappers.toDBO
import dev.smolyakoff.chucknorris.features.fact.data.mappers.toModel
import dev.smolyakoff.chucknorris.features.fact.domain.model.FactModel
import dev.smolyakoff.chucknorris.features.fact.domain.repository.FactsRepository
import dev.smolyakoff.chucknorris.features.fact.local.FactsDao

class FactsRepositoryImpl(
    private val service: FactsService,
    private val dao: FactsDao
) : FactsRepository {

    @Throws(Throwable::class)
    override suspend fun randomFact(): FactModel {

        val response = service.randomFact()

        dao.insertFact(response.toDBO())

        return response.toModel()
    }

}