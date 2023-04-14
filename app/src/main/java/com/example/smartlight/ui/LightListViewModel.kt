package com.example.smartlight.ui

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartlight.domain.model.Data
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
    private val _lightState: MutableState<List<Data>> = mutableStateOf(ArrayList())
    val lightState: State<List<Data>> = _lightState

    val isLoading = mutableStateOf(false)
    private var listScrollPosition: Int = 0

    init {
        getLightInfo()
    }

    fun onTriggerEvent(event: LightListEvent){
        viewModelScope.launch {
            try {
                when(event){
                    is LightListEvent.NewLightSearchEvent -> postLight()
                }
            }catch (e: Exception){
                Log.e(TAG, "BookListViewModel: onTriggerEvent: Exception ${e}, ${e.cause}")
            }
        }
    }


    private fun getLightInfo(){
        getLightListUC.execute().onEach { dataState ->
            isLoading.value = dataState.loading
            dataState.data?.let { list -> _lightState.value = list }
            dataState.error?.let { error -> Log.e(TAG,"LightListViewModel: getLightListUC: Error: $error")}
        }.launchIn(viewModelScope)
    }

    private suspend fun postLight(){
        Log.i(TAG, "postLight running")

        postLightUC.execute()
    }

    fun onChangedBookScrollPosition(position: Int){
        listScrollPosition = position
    }
}