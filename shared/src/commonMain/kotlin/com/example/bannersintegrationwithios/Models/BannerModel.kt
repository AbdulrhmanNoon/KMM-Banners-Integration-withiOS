package com.example.bannersintegrationwithios.Models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BannerResponse (
     @SerialName("data") val data : List<BannerModel>,
)
@Serializable
data class BannerModel (
     @SerialName("image") val image : String?,
    // @SerialName("html") val html : String?,
     @SerialName("is_visible") val isVisible : String?,
     @SerialName("link") val link : String?,
     @SerialName("duration") val duration : Int?,
     @SerialName("position") val sortIndex : Int?,
     @SerialName("updated_at") val updated_at : String?,
     @SerialName("created_at") val created_at : String?
)

