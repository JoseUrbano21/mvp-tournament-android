package com.pkm.mvptournament

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.pkm.mvptournament.ui.components.AppRoot
import com.pkm.mvptournament.ui.theme.MVPTournamentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MVPTournamentTheme {
                AppRoot()
            }
        }
    }
}