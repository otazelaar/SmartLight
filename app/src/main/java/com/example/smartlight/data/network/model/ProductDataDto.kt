package com.example.smartlight.data.network.model

import com.example.smartlight.domain.model.ProductData
import com.google.gson.annotations.SerializedName

data class ProductDataDto(
    @SerializedName("certified") var certified: Boolean,
    @SerializedName("hardware_platform_type") var hardware_platform_type: String,
    @SerializedName("manufacturer_name") var manufacturer_name: String,
    @SerializedName("model_id") var model_id: String,
    @SerializedName("product_archetype") var product_archetype: String,
    @SerializedName("product_name") var product_name: String,
    @SerializedName("software_version") var software_version: String
)

fun ProductDataDto.toProductData(): ProductData{
    return ProductData(
        certified = certified,
        hardware_platform_type = hardware_platform_type,
        manufacturer_name = manufacturer_name,
        model_id = model_id,
        product_archetype = product_archetype,
        product_name = product_name,
        software_version = software_version
    )
}