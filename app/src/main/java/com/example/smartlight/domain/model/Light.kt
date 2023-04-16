package com.example.smartlight.domain.model

import com.example.smartlight.data.network.model.MetadataDto
import com.example.smartlight.data.network.model.ProductDataDto

data class Light(
    val id: String,
    val id_v1: String?,
    val metadataDto: MetadataDto,
    val product_data: ProductDataDto,
    val serviceId: String,
    val type: String,
    val toggleLight: Boolean,
)