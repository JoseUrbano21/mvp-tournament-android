package com.pkm.mvptournament.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val BrandColorScheme = lightColorScheme(
    /* Top App Bar colors */
    surface = BgHead,
    onSurface = TextGoldShiny,

    /* Main screen colors */
    background = BgGrad1,
    onBackground = TextBlueSky,
    primary = TextGoldDark, // Rule cards
    onPrimary = TextBlueSky,

    /* Bottom App Bar colors */
    surfaceVariant = BgNav,
    onSurfaceVariant = TextBlueSky,

    /* Miscelaneous */
    error = BgBtn
)

@Composable
fun MVPTournamentTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = BrandColorScheme,
        typography = Typography,
        content = content
    )
}