package com.example.smartlight.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.SemanticsActions
import androidx.compose.ui.test.isToggleable
import androidx.core.app.NotificationCompat.Action.SemanticAction
import com.example.smartlight.domain.model.Light

@Composable
fun LightListView(
    light: Light,
    onClickedLightOnEvent: (Light) -> Unit,
){
    Row{
        Text(
            text = "${light.metadataDto.name} ${light.id}",
            color = androidx.compose.ui.graphics.Color.Red,
            modifier = Modifier
                .clickable(
                    onClick = {
                        onClickedLightOnEvent(light)
                }),
            style = MaterialTheme.typography.h4,
        )
    }
}