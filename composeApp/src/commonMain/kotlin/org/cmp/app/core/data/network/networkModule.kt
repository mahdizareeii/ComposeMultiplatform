package org.cmp.app.core.data.network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.cmp.app.core.data.network.api.ProductApi
import org.koin.dsl.module

val networkModule = module {
    single {
        HttpClient(get()) {
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        println("cmp_network: $message")
                    }
                }
                level = LogLevel.ALL
            }
            install(ContentNegotiation) {
                json(
                    Json { ignoreUnknownKeys = true },
                    contentType = ContentType.Any
                )
            }
        }
    }

    factory { ProductApi(httpClient = get()) }
}