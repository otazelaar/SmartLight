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
    suspend fun execute(
        serviceId: String,
        toggleLight: Boolean,
    ) {
        postLightToNetwork(serviceId, toggleLight)
    }

    private suspend fun postLightToNetwork(serviceId: String, toggleLight: Boolean): Response{

        // check state of light
        // change Boolean value to opposite of wtv
        val body = Json(on = On(on = toggleLight))

        Log.e(TAG, "JSON postlighttonetwork is running")

        val apiCall = phillipsHueApiService.putLight(
            serviceId = serviceId,
            body = body
        )
        Log.e(TAG, "JSON to see: $body")

        return apiCall
    }

}