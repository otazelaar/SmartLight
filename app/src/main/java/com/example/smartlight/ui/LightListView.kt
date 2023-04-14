package com.example.smartlight.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.smartlight.domain.model.Data

@Composable
fun LightListView(
    light: Data,
    newLightSelectedEvent: (Data) -> Unit,
    newLightOnEvent: () -> Unit,
    isSelected: Boolean = false,
){
    Row{
        Text(
            text = light.id,
            color = androidx.compose.ui.graphics.Color.Red,
            modifier = Modifier
                .clickable(
                    enabled = !isSelected,
                    onClick = {
                        newLightSelectedEvent(light)
                        newLightOnEvent()
                }),
            style = MaterialTheme.typography.h4,
        )
    }
}