package com.example.smartlight.ui

/**
 * This class is used to define routes for compose only navigation.
 */

sealed class Screen(
    val route: String,
){
    object LightList: Screen("lightList")
    object LightDetail: Screen("lightDetail")
}