package ru.isaev.whacamoletest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import ru.isaev.whacamoletest.navigation.Navigation
import ru.isaev.whacamoletest.ui.screen.MainScreen.MainScreen
import ru.isaev.whacamoletest.ui.screen.MainScreen.MainViewModel
import ru.isaev.whacamoletest.ui.theme.WhacAMoleTestTheme

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



