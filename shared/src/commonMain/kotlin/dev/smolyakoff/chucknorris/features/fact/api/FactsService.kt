package dev.smolyakoff.chucknorris.features.fact.api

import dev.smolyakoff.chucknorris.features.fact.data.dto.FactResponseDTO
import dev.smolyakoff.chucknorris.network.ktor.KtorClient
import io.ktor.client.call.body
import io.ktor.client.request.get

interface FactsService {

    @Throws(Throwable::class)
    suspend fun randomFact(): FactResponseDTO

}

class FactsServiceImpl(
    private val ktor: KtorClient
) : FactsService {

    @Throws(Throwable::class)
    override suspend fun randomFact(): FactResponseDTO {
        val response = ktor
            .getClient()
            .get("jokes/random")

        return response.body()
    }

}
