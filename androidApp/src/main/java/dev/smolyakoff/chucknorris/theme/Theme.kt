package dev.smolyakoff.chucknorris.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = DeepGreen.copy(0.9f),
    background = Color.Black,
    secondary = Color.White.copy(0.9f)
)

private val LightColorScheme = darkColorScheme(
    primary = DeepGreen,
    background = Color.White,
    secondary = Color.Black.copy(0.9f)
)

@Composable
fun NorrisTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        shapes = shapes,
        content = content
    )
}
