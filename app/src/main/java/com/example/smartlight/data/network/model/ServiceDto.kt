package com.example.smartlight.data.network.model

import com.example.smartlight.domain.model.Service
import com.google.gson.annotations.SerializedName

data class ServiceDto(
    @SerializedName("rid") var rid: String,
    @SerializedName("rtype") var rtype: String
)

fun ServiceDto.toService(): Service{
    return Service(
        rid = rid,
        rtype = rtype,
    )
}