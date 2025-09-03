package com.pkm.mvptournament.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pkm.mvptournament.ui.screens.HomeScreen
import com.pkm.mvptournament.ui.screens.LoginScreen
import com.pkm.mvptournament.ui.screens.SignupScreen

// Paths definition
sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Signup : Screen("signup")
    object Home : Screen("home")
}

@Composable
fun NavGraph(navController: NavHostController) {
    // Home page
    NavHost(navController = navController, startDestination = Screen.Login.route) {
        composable(Screen.Login.route) { LoginScreen(navController) }
        composable(Screen.Signup.route) { SignupScreen(navController) }
        composable(Screen.Home.route) { HomeScreen(navController) }
    }
}
