package com.pinterest.optimizer.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

private val LightColorScheme = lightColorScheme(
    primary = PinterestRed,
    onPrimary = PinterestWhite,
    primaryContainer = PinterestLightGray,
    onPrimaryContainer = PinterestBlack,
    secondary = PinterestGray,
    onSecondary = PinterestWhite,
    background = PinterestWhite,
    onBackground = PinterestBlack,
    surface = PinterestWhite,
    onSurface = PinterestBlack,
    error = PinterestRed,
    onError = PinterestWhite
)

private val DarkColorScheme = darkColorScheme(
    primary = PinterestRed,
    onPrimary = PinterestWhite,
    primaryContainer = PinterestBlack,
    onPrimaryContainer = PinterestWhite,
    secondary = PinterestGray,
    onSecondary = PinterestWhite,
    background = PinterestBlack,
    onBackground = PinterestWhite,
    surface = PinterestBlack,
    onSurface = PinterestWhite,
    error = PinterestRed,
    onError = PinterestWhite
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
)

@Composable
fun PinterestOptimizerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
