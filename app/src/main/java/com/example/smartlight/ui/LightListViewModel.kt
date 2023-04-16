package com.example.smartlight.ui

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartlight.domain.model.Light
import com.example.smartlight.domain.use_case.GetLightListUC
import com.example.smartlight.domain.use_case.PostLightUC
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LightListViewModel @Inject constructor(
    private val getLightListUC: GetLightListUC,
    private val postLightUC: PostLightUC,
): ViewModel() {
    private val _lightListState: MutableState<List<Light>> = mutableStateOf(ArrayList())
    val lightListState: State<List<Light>> = _lightListState

    val isLoading = mutableStateOf(false)
    private var listScrollPosition: Int = 0

    init {
        getLightInfo()
    }

    fun onTriggerEvent(event: LightListEvent){
        viewModelScope.launch {
            try {
                when(event){
                    is LightListEvent.OnClickLightOnEvent -> postLight(event.light)
                }
            }catch (e: Exception){
                Log.e(TAG, "BookListViewModel: onTriggerEvent: Exception ${e}, ${e.cause}")
            }
        }
    }


    private fun getLightInfo(){
        getLightListUC.execute().onEach { dataState ->
            isLoading.value = dataState.loading
            dataState.data?.let { list -> _lightListState.value = list }
            dataState.error?.let { error -> Log.e(TAG,"LightListViewModel: getLightListUC: Error: $error")}
        }.launchIn(viewModelScope)
    }

    private suspend fun postLight(light: Light){
        Log.i(TAG, "postLight running")
        val serviceId = light.serviceId
        val toggleLight = !light.toggleLight

        postLightUC.execute(serviceId, toggleLight)
        // store toggleLightSate everytime I call this UC so that I can check
        // if the light is on or off when calling this function.
    }

    fun onChangedBookScrollPosition(position: Int){
        listScrollPosition = position
    }
}