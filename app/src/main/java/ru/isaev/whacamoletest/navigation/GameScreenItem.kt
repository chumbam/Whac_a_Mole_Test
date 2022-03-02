package ru.isaev.whacamoletest.navigation

sealed class GameScreenItem(val route: String) {
    object StartScreen : GameScreenItem(route = "StartScreen")
    object MainScreen : GameScreenItem(route = "MainScreen")
    object ScoreScreen : GameScreenItem(route = "ScoreScreen")

}
