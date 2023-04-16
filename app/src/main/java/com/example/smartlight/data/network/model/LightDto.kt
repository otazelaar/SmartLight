package com.example.smartlight.data.network.model

import com.example.smartlight.domain.model.Light
import com.google.gson.annotations.SerializedName

data class LightDto(
    @SerializedName("id") var id: String,
    @SerializedName("id_v1") var id_v1: String?,
    @SerializedName("metadata") var metadataDto: MetadataDto,
    @SerializedName("product_data") var productDataDto: ProductDataDto,
    @SerializedName("services") var servicesDtos: List<ServiceDto>,
    @SerializedName("type") var type: String
)

fun List<ServiceDto>.getListServiceId(): String {
    return this.find { serviceDto ->
        serviceDto.rtype == "light"
    }?.rid.orEmpty()
}

fun LightDto.toData(): Light {
    return Light(
        id = id,
        id_v1 = id_v1,
        metadataDto = metadataDto,
        product_data = productDataDto,
        serviceId = servicesDtos.getListServiceId(),
        type = type,
        toggleLight = false,
    )
}