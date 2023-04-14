package com.example.smartlight.data.network.model

import com.example.smartlight.domain.model.Data
import com.google.gson.annotations.SerializedName

data class DataDto(
    @SerializedName("id") var id: String,
    @SerializedName("id_v1") var id_v1: String?,
    @SerializedName("metadata") var metadataDto: MetadataDto,
    @SerializedName("product_data") var productDataDto: ProductDataDto,
    @SerializedName("services") var servicesDtos: List<ServiceDto>,
    @SerializedName("type") var type: String
)

fun DataDto.toData(): Data {
    return Data(
        id = id,
        id_v1 = id_v1,
        metadataDto = metadataDto,
        product_data = productDataDto,
        serviceDtos = servicesDtos,
        type = type,
    )
}