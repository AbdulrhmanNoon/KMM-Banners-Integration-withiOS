package com.example.bannersintegrationwithios.Network

import com.example.bannersintegrationwithios.Models.BannerResponse
import io.ktor.http.*
import kotlinx.serialization.Serializable

interface Api {
    suspend fun getBanners(baseUrl: String, token: String): BannerResponse
}

//data class ApiRequest(
//    val serviceName: String,
//    val headers: HttpHeaders,
//    val httpMethod: HttpMethod
//)