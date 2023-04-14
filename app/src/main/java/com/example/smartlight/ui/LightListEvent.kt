package com.example.smartlight.ui

import com.example.smartlight.domain.model.Light

/**
 * This class is used to trigger events related to the BookListViewModel
 */
sealed class LightListEvent {
    data class OnClickLightOnEvent(
        val light: Light,
    ): LightListEvent()
}