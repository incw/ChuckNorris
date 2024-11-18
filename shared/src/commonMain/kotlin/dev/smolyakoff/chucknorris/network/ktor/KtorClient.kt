package dev.smolyakoff.chucknorris.network.ktor

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.request.header
import io.ktor.http.ContentType.Application.Json
import io.ktor.http.HttpHeaders
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


interface KtorClient {
    fun getClient(): HttpClient
}


class KtorClientImpl : KtorClient {


    private companion object {
        private const val BASE_URL = "api.chucknorris.io"
    }

    override fun getClient() = ktorClient


    private val ktorClient = httpClient {

        install(Logging) {
            logger = Logger.SIMPLE
            level = LogLevel.ALL
        }

        expectSuccess = true


        defaultRequest {

            header(HttpHeaders.ContentType, Json)

            host = BASE_URL

            url {
                protocol = URLProtocol.HTTPS

            }
        }

        install(ContentNegotiation) {
            json(
                Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                }
            )
        }

    }

}
