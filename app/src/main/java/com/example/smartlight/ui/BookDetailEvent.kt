package com.example.smartlight.ui

/**
 * This class is used to trigger events related to the BookDetailViewModel
 */
sealed class BookDetailEvent {

    data class GetLightDetailEvent(
        val light_id: String,
    ): BookDetailEvent()
}