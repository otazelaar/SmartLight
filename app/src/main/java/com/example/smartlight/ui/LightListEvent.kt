package com.example.smartlight.ui

/**
 * This class is used to trigger events related to the BookListViewModel
 */
sealed class LightListEvent {
    object NewLightSearchEvent: LightListEvent()
}