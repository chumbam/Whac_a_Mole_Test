package ru.isaev.whacamoletest.ui.screen.ScoreScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.isaev.whacamoletest.R
import ru.isaev.whacamoletest.navigation.GameScreenItem
import ru.isaev.whacamoletest.ui.screen.MainViewModel

@Composable
fun ScoreScreen(viewModel: MainViewModel, navController: NavHostController) {

    val color = Color(0xffa03623)
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.final_screen),
            contentDescription = "FinalScreen",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Text(
            text = "Your record: ${viewModel.record}",
            modifier = Modifier.align(Alignment.BottomEnd).padding(end = 16.dp, top = 16.dp)
        )

        Column(
            modifier = Modifier.fillMaxSize().padding(top = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Score: ${viewModel.score.value}",
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
            )
            OutlinedButton(onClick = {
                if (viewModel.score.value > viewModel.record) {
                    viewModel.record = viewModel.score.value
                }
                viewModel._score.value = 0
                navController.navigate(GameScreenItem.StartScreen.route){
                    popUpTo(0)
                }

            }, modifier = Modifier.clip(CircleShape), colors = ButtonDefaults.buttonColors(color)) {
                Text(text = stringResource(R.string.btn_to_menu_text))
            }
            OutlinedButton(
                onClick = {
                    if (viewModel.score.value > viewModel.record) {
                        viewModel.record = viewModel.score.value
                    }
                    viewModel._score.value = 0

                    navController.navigate(GameScreenItem.MainScreen.route){
                        popUpTo(0)
                    }
                    viewModel.startGameTimer(context, navController)


                },
                modifier = Modifier.clip(CircleShape),
                colors = ButtonDefaults.buttonColors(color)
            ) {
                Text(text = stringResource(R.string.btn_tryagain_text))
            }
        }
    }
}