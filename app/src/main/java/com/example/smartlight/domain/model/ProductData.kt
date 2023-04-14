package com.example.smartlight.domain.model

data class ProductData(
    val certified: Boolean,
    val hardware_platform_type: String,
    val manufacturer_name: String,
    val model_id: String,
    val product_archetype: String,
    val product_name: String,
    val software_version: String
)