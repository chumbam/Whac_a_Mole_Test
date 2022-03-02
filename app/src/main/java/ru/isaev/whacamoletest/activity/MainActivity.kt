package ru.isaev.whacamoletest.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Scaffold
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.isaev.whacamoletest.navigation.Navigation
import ru.isaev.whacamoletest.ui.screen.MainViewModel
import ru.isaev.whacamoletest.ui.theme.WhacAMoleTestTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            WhacAMoleTestTheme {
                Scaffold {
                    Navigation(viewModel = viewModel, navController = navController )
                }

            }
        }
    }
}



