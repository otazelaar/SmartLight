package com.example.smartlight.domain.use_case

import android.content.ContentValues.TAG
import android.util.Log
import com.example.smartlight.data.network.PhillipsHueApiService
import com.example.smartlight.data.network.model.Response
import com.example.smartlight.domain.Json
import com.example.smartlight.domain.On
import kotlinx.coroutines.flow.flow
import org.json.JSONObject

class PostLightUC(
    private val phillipsHueApiService: PhillipsHueApiService,
) {
    suspend fun execute() {
        postLightToNetwork()
    }

    private suspend fun postLightToNetwork(): Response{
        val body = Json(on = On(on = true))

        Log.e(TAG, "JSON postlighttonetwork is running")

        val apiCall = phillipsHueApiService.putLight(
            body = body
        )
        Log.e(TAG, "JSON to see: $body")

        return apiCall
    }

}