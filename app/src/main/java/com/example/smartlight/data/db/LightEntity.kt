package com.example.smartlight.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.smartlight.domain.model.Light

@Entity(tableName = "Lights")
data class LightEntity(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "toggleLight")
    val toggleLight: Boolean,
)

fun LightEntity.toLight(): Light {
    return Light(
        id = id,
        toggleLight = toggleLight,
        id_v1 = null,
        metadataDto = null,
        product_data = null,
        serviceId = null,
        type = null,
    )
}

fun entitiesToBook(bookEntities: List<LightEntity>): List<Light> {
    return bookEntities.map { it.toLight() }
}
