package com.pkm.mvptournament.ui.components

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.pkm.mvptournament.navigation.NavGraph

@Composable
fun AppRoot(){
    val navController = rememberNavController()

    NavGraph(navController = navController)
}