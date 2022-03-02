package ru.isaev.whacamoletest.ui.screen.StartScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape

import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import ru.isaev.whacamoletest.R
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.isaev.whacamoletest.GameScreenItem
import ru.isaev.whacamoletest.ui.screen.MainScreen.MainViewModel


@Composable
fun StartScreen(viewModel: MainViewModel, navController: NavHostController) {

    Box(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(R.drawable.mole),
                contentDescription = "MoleStartScreen",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )


        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Правила игры",
                color = Color.Black
            )
            Text(
                text = stringResource(R.string.game_rules_text),
                modifier = Modifier.padding(bottom = 144.dp),
                color = Color.Black
            )

//            Button(onClick = {}, modifier = Modifier.padding(bottom = 8.dp).size(height = 96.dp, width = 128.dp)) {
//
//            }
            Card(
                modifier = Modifier.padding(bottom = 8.dp).size(height = 80.dp, width = 120.dp)
                    .clickable {
                        navController.navigate(GameScreenItem.MainScreen.route)
                        viewModel.startGame()
                    },
                shape = CircleShape
            ) {
                Image(
                    painterResource(R.drawable.button),
                    contentScale = ContentScale.Inside,
                    contentDescription = ""
                )
            }
        }

    }
}

//@Preview(showBackground = true)
//@Composable
//fun StartScreenPreview() {
//    StartScreen()
//}