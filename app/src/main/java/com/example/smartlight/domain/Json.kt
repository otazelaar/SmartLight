package com.example.smartlight.domain

import com.google.gson.annotations.SerializedName

data class Json(
    @SerializedName("on") val on: On
)

data class On(
    @SerializedName("on") val on: Boolean
)

//val myJsonBody: Json = Gson().fromJson()
//val outputJson: String = Gson().toJson(myJsonBody)
//
//val client = OkHttpClient()
//
//val mediaType = "application/json".toMediaTypeOrNull()
//val body = "{\"on\": {\"on\": true}}".toRequestBody(mediaType)
//val request = Request.Builder()
//    .url("https:///%3Cipaddress%3E/clip/v2/resource/light/%3Cv2-id%3E")
//    .put(body)
//    .addHeader("hue-application-key", "<appkey>")
//    .addHeader("Content-Type", "application/json")
//    .build()
//
//val response = client.newCall(request).execute()