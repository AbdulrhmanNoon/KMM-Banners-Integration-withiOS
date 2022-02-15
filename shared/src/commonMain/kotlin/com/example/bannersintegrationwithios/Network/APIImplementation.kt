package com.example.bannersintegrationwithios.Network

import com.example.bannersintegrationwithios.Models.AppData
import com.example.bannersintegrationwithios.Models.BannerResponse
import com.linecorp.abc.sharedstorage.SharedStorage
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*

import kotlinx.serialization.Serializable

class APIImplementation: Api {
    private val httpClient = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
                coerceInputValues = true
            })
        }
    }

    override suspend fun getBanners(baseUrl: String, token: String): BannerResponse{

        SharedStorage.save(token, "key::String")

        return httpClient.get("${baseUrl}/banner/mobile"){
            headers {
                append(HttpHeaders.Authorization, token)
                append(HttpHeaders.AcceptLanguage, "en")
            }
        }
    }

}
