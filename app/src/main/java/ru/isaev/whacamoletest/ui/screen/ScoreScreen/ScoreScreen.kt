package ru.isaev.whacamoletest.ui.screen.ScoreScreen

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import ru.isaev.whacamoletest.GameScreenItem
import ru.isaev.whacamoletest.ui.screen.MainScreen.MainViewModel

@Composable
fun ScoreScreen(viewModel: MainViewModel, navController: NavHostController) {
    Text(text = "Score: ${viewModel.score}")
    Button(onClick = { navController.navigate(GameScreenItem.StartScreen.route) }) {
        Text(text = "ToStartScreen")
    }
    Button(onClick = {
        navController.navigate(GameScreenItem.MainScreen.route) {
            viewModel.startGame()
        }
    }) {
        Text(text = "TryAgain")
    }
}