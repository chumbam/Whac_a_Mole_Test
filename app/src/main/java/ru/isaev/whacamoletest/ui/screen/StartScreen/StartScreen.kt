package ru.isaev.whacamoletest.ui.screen.StartScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import ru.isaev.whacamoletest.R
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.isaev.whacamoletest.navigation.GameScreenItem
import ru.isaev.whacamoletest.ui.screen.MainViewModel


@Composable
fun StartScreen(viewModel: MainViewModel, navController: NavHostController) {

    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(R.drawable.start_screen),
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
            Row(
                modifier = Modifier.fillMaxWidth().height(112.dp).padding(bottom = 8.dp)
                    .shadow(2.dp).padding(start = 2.dp, end = 2.dp),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Start,

                ) {
                Column(modifier = Modifier.weight(1f).fillMaxSize()) {
                    Text(
                        text = stringResource(R.string.game_rules_head),
                        color = Color.Black,
                        modifier = Modifier.padding(start = 14.dp),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = stringResource(R.string.game_rules_text),
                        color = Color.Black,
                        modifier = Modifier.padding(start = 14.dp)
                    )
                }
                Divider(modifier = Modifier.fillMaxHeight().shadow(2.dp).width(1.dp))
                Column(modifier = Modifier.weight(1f).fillMaxSize().padding(end = 2.dp)) {
                    Text(
                        text = stringResource(R.string.your_record),
                        color = Color.Black,
                        modifier = Modifier.padding(start = 14.dp),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = viewModel.record.toString(),
                        color = Color.Black,
                        modifier = Modifier.padding(start = 14.dp)

                    )
                }

            }

            Image(
                painterResource(R.drawable.button_f),
                contentScale = ContentScale.Crop,
                contentDescription = "",
                modifier = Modifier.padding(bottom = 8.dp)
                    .size(height = 80.dp, width = 120.dp).clip(
                        CircleShape
                    ).clickable {
                        navController.navigate(GameScreenItem.MainScreen.route) {
                            viewModel.startGameTimer(context, navController)
                        }
                    }
            )


        }
    }
}



