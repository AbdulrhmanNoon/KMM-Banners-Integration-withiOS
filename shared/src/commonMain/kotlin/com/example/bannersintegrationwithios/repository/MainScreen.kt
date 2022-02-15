package com.example.bannersintegrationwithios.repository

import com.example.bannersintegrationwithios.Network.APIImplementation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainScreen {
    suspend fun getBanners(baseUrl: String, token: String) = withContext(Dispatchers.Default) {
        val response = APIImplementation().getBanners(baseUrl, token)
        response
/*
if (response.status && response.result.isNotEmpty())
response.result
else
BannerData.getDummyBanners()
*/
    }
}
