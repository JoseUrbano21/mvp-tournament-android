package com.pkm.mvptournament.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.pkm.mvptournament.ui.theme.MVPTournamentTheme

@Composable
fun SignupScreen(navController: NavController){

}

@Preview(showBackground = true)
@Composable
fun PreviewSignupScreen() {
    MVPTournamentTheme {
        SignupScreen(navController = rememberNavController())
    }
}