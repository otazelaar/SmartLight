package com.example.smartlight.ui

import com.example.smartlight.domain.model.Light

sealed class LightListEvent {
    data class OnClickLightOnEvent(
        val light: Light,
    ): LightListEvent()
}