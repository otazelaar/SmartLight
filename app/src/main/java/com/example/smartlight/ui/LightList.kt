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
import com.example.smartlight.domain.model.Data

@Composable
fun LightList(
    lights: List<Data>,
    onChangeBookScrollPosition: (Int) -> Unit,
    onChangedScrollPosition: (Int) -> Unit,
    newLightSearchEvent: () -> Unit,
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
                items = lights,
            ){index, light ->
                onChangeBookScrollPosition(index)
                LightListView(
                    light = light,
                    newLightSelectedEvent = {
                        // Not sure about the following function and what it is doing yet
                        onChangedScrollPosition(lightListScrollState.firstVisibleItemIndex)
                        newLightSearchEvent()
                    },
                    newLightOnEvent = newLightSearchEvent,
                )
            }
        }
    }
}