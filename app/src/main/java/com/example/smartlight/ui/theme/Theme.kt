package com.example.smartlight.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.otaz.nytbooksapplication.ui.theme.AppShapes

private val LightThemeColors = lightColors(
    primary = Yellow700,
    primaryVariant = Yellow500,
    onPrimary = Black,
    secondary = Color.White,
    secondaryVariant = Yellow300,
    onSecondary = Color.Black,
    error = RedErrorDark,
    onError = RedErrorLight,
    background = Color.White,
    onBackground = Color.Black,
    surface = Grey,
    onSurface = Black,
)

private val DarkThemeColors = darkColors(
    primary = Yellow700,
    primaryVariant = Color.White,
    onPrimary = Color.White,
    secondary = DarkGrey,
    onSecondary = Color.White,
    error = RedErrorLight,
    background = Color.Black,
    onBackground = Color.White,
    surface = DarkGrey,
    onSurface = Color.White,
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    systemUiController: SystemUiController = rememberSystemUiController(),
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colors = if (darkTheme) DarkThemeColors else LightThemeColors,
        typography = QuickSandTypography,
        shapes = AppShapes
    ){
        if(darkTheme){
            systemUiController.setSystemBarsColor(
                color = Color.Transparent
            )
        } else{
            systemUiController.setSystemBarsColor(
                color = Color.Transparent,
                darkIcons = true
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier.background(MaterialTheme.colors.background)
            ){
                content()
            }
        }
    }
}