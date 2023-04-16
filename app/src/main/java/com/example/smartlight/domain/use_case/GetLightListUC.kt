package com.example.smartlight.domain.use_case

import android.content.ContentValues.TAG
import android.util.Log
import com.example.smartlight.data.network.PhillipsHueApiService
import com.example.smartlight.data.network.model.toData
import com.example.smartlight.domain.model.Light
import com.example.smartlight.domain.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetLightListUC(
    private val phillipsHueApiService: PhillipsHueApiService,
) {
    fun execute(): Flow<DataState<List<Light>>> = flow {
        try {
            emit(DataState.loading())

            val lights = getLightInfoNetworkCall()

            emit(DataState.success(lights))

            Log.i(TAG, "Here it is: $lights")

        } catch (e: Exception) {
            emit(DataState.error(e.message ?: "GetLightInfoUC: Unknown error"))
        }
    }

    private suspend fun getLightInfoNetworkCall(): List<Light> {
        return phillipsHueApiService.getLights().lightDto.map { it.toData() }
    }

//    private suspend fun getLightInfoNetworkCall2(): List<Service> {
//        return phillipsHueApiService.getLights2().servicesDtos.map { it.toService() }
//    }

}