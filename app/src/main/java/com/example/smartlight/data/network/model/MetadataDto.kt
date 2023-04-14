package com.example.smartlight.data.network.model

import com.google.gson.annotations.SerializedName

data class MetadataDto(
    @SerializedName("archetype") var archetype: String,
    @SerializedName("name") var name: String
)

fun MetadataDto.toMetadata(): com.example.smartlight.domain.model.Metadata{
    return com.example.smartlight.domain.model.Metadata(
        archetype = archetype,
        name = name,
    )
}