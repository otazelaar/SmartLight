package com.example.smartlight.data.network

import com.example.smartlight.data.network.model.Response
import com.example.smartlight.domain.Json
import com.example.smartlight.domain.model.Service
import org.json.JSONObject
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.PUT
import retrofit2.http.Path

interface PhillipsHueApiService {

    /**
     * Returns information about lights in JSON from Phillips Hue Api
     */
    @Headers("hue-application-key: KcILknKbQqAyXpaSXmtrisaUoqOti2JGq3PZDDmO")
    @GET("clip/v2/resource/device")
    suspend fun getLights(): Response


    @Headers( "hue-application-key: KcILknKbQqAyXpaSXmtrisaUoqOti2JGq3PZDDmO")
    @PUT("clip/v2/resource/light/{serviceId}")
    suspend fun putLight(
        @Path("serviceId") serviceId: String,
        @Body body: Json
    ): Response

}