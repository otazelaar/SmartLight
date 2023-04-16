package com.example.smartlight.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.isToggleable
import com.example.smartlight.domain.model.Light

@Composable
fun LightList(
    Lights: List<Light>,
    onChangeBookScrollPosition: (Int) -> Unit,
    onChangedScrollPosition: (Int) -> Unit,
    onClickLightOnEvent: (Light) -> Unit,
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.background)
    ) {
        val lightListScrollState = rememberLazyListState()
        LazyColumn(
            state = lightListScrollState,
        ){
            itemsIndexed(
                items = Lights,
            ){index, light ->
                onChangeBookScrollPosition(index)
                LightListView(
                    light = light,
                    onClickedLightOnEvent = {
                        onChangedScrollPosition(lightListScrollState.firstVisibleItemIndex)
                        onClickLightOnEvent(light)
                    },
                )
            }
        }
    }
}