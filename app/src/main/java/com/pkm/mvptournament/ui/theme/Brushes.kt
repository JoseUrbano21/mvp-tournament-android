package com.pkm.mvptournament.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

object MVPBrushes {
    @Composable
    fun dividerGlow(): Brush {
        val color = MaterialTheme.colorScheme.onBackground
        return remember(color) {
            Brush.horizontalGradient(listOf(Color.Transparent, color, Color.Transparent))
        }
    }
}