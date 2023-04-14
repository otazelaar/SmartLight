package com.example.smartlight.data.network

import com.example.smartlight.data.network.model.Response
import com.example.smartlight.domain.Json
import org.json.JSONObject
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.PUT

interface PhillipsHueApiService {

    /**
     * Returns information about lights in JSON from Phillips Hue Api
     */
    @Headers("hue-application-key: KcILknKbQqAyXpaSXmtrisaUoqOti2JGq3PZDDmO")
    @GET("clip/v2/resource/device")
    suspend fun getLights(): Response


    @Headers( "hue-application-key: KcILknKbQqAyXpaSXmtrisaUoqOti2JGq3PZDDmO")
    @PUT("clip/v2/resource/light/2d3d482c-782c-43af-92c9-b3bd4ee09388")
    suspend fun putLight(@Body body: Json): Response

}