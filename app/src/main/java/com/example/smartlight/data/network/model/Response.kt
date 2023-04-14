package com.example.smartlight.data.network.model

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("data") var dataDto: List<DataDto>,
)