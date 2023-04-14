package com.example.smartlight.domain.model

import com.example.smartlight.data.network.model.MetadataDto
import com.example.smartlight.data.network.model.ProductDataDto
import com.example.smartlight.data.network.model.ServiceDto

data class Data(
    val id: String,
    val id_v1: String?,
    val metadataDto: MetadataDto,
    val product_data: ProductDataDto,
    val serviceDtos: List<ServiceDto>,
    val type: String
)