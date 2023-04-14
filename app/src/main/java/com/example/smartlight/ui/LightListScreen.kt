package com.example.smartlight.ui

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalFocusManager
import com.example.smartlight.ui.theme.AppTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LightListScreen(
    lightListViewModel: LightListViewModel,
) {
    val lights = lightListViewModel.lightState.value

    AppTheme {
        Scaffold{
            LightList(
                lights = lights,
                onChangeBookScrollPosition = lightListViewModel::onChangedBookScrollPosition,
                onChangedScrollPosition = lightListViewModel::onChangedBookScrollPosition,
                newLightSearchEvent = { lightListViewModel.onTriggerEvent(LightListEvent.NewLightSearchEvent) },
            )
        }
    }
}