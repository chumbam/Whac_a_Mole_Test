package ru.isaev.whacamoletest.ui.screen.MainScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.isaev.whacamoletest.R
import ru.isaev.whacamoletest.ui.view.BattleField


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen(viewModel: MainViewModel, navController: NavHostController) {


    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = painterResource(R.drawable.main_screen),
            contentDescription = "MainScreen",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Text(
            text = "Time: ${viewModel.timer.value}",
            modifier = Modifier.align(Alignment.TopStart)
                .padding(start = 16.dp, top = 16.dp).shadow(2.dp).clickable { viewModel.startGame() }
        )
        Text(
            text = "Score: ${viewModel.score.value.toString()}",
            modifier = Modifier.align(Alignment.TopEnd)
                .padding(16.dp).shadow(2.dp).clickable { viewModel.startGame() }
        )

        Box(
            modifier = Modifier.fillMaxWidth().height(526.dp)
                .padding(top = 96.dp, start = 16.dp, end = 16.dp)
        ) {
            BattleField(viewModel)
        }
    }

}

