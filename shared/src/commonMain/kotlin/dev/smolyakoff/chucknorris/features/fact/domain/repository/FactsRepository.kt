package dev.smolyakoff.chucknorris.features.fact.domain.repository

import dev.smolyakoff.chucknorris.features.fact.domain.model.FactModel

interface FactsRepository {

    @Throws(Throwable::class)
    suspend fun randomFact(): FactModel

}