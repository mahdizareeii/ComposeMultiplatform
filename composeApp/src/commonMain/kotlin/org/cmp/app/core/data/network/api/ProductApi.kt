package org.cmp.app.core.data.network.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType
import org.cmp.app.core.data.network.model.ProductDto

class ProductApi(
    private val httpClient: HttpClient
) {

    suspend fun getProducts(): Result<List<ProductDto>> {
        return try {
            Result.success(
                httpClient.get("https://raw.githubusercontent.com/Kotlin/KMP-App-Template/main/list.json") {
                    //contentType(ContentType.Application.Json)
                }.body<List<ProductDto>>()
            )
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}