package com.example.smartlight.ui

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.example.smartlight.ui.theme.AppTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LightListScreen(
    lightListViewModel: LightListViewModel,
) {
    val lights = lightListViewModel.lightListState.value

    AppTheme {
        Scaffold{
            LightList(
                Lights = lights,
                onChangeBookScrollPosition = lightListViewModel::onChangedBookScrollPosition,
                onChangedScrollPosition = lightListViewModel::onChangedBookScrollPosition,
                onClickLightOnEvent = { light ->
                    lightListViewModel.onTriggerEvent(LightListEvent.OnClickLightOnEvent(light))
                },
            )
        }
    }
}