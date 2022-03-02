package ru.isaev.whacamoletest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.isaev.whacamoletest.GameScreenItem
import ru.isaev.whacamoletest.ui.screen.MainScreen.MainScreen
import ru.isaev.whacamoletest.ui.screen.MainScreen.MainViewModel
import ru.isaev.whacamoletest.ui.screen.ScoreScreen.ScoreScreen
import ru.isaev.whacamoletest.ui.screen.StartScreen.StartScreen

@Composable
fun Navigation(navController: NavHostController, viewModel: MainViewModel) {
    NavHost(navController = navController, startDestination = GameScreenItem.StartScreen.route) {
        composable(route = GameScreenItem.StartScreen.route) {
            StartScreen(viewModel = viewModel, navController =  navController)
        }
        composable(route = GameScreenItem.MainScreen.route) {
            MainScreen(viewModel = viewModel, navController =  navController)
        }
        composable(route = GameScreenItem.ScoreScreen.route) {
            ScoreScreen(viewModel = viewModel, navController =  navController)
        }

    }
}