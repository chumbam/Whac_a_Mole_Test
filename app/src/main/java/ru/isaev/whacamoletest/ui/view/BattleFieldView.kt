package  ru.isaev.whacamoletest.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.isaev.whacamoletest.ui.screen.MainScreen.MainViewModel

@Composable
fun BoxScope.BattleField(viewModel: MainViewModel ) {

    //FirstRow
    Row(modifier = Modifier.fillMaxWidth().align(Alignment.TopCenter).height(150.dp)) {
        CustomBox(
            viewModel = viewModel,
            moleNumStatus = viewModel.moleout1.value)
        CustomBox(
            viewModel = viewModel,
            moleNumStatus = viewModel.moleout2.value)
        CustomBox(
            viewModel = viewModel,
            moleNumStatus = viewModel.moleout3.value)
    }
    //SecondRow
    Row(modifier = Modifier.fillMaxWidth().align(Alignment.Center).height(150.dp)) {
        CustomBox(
            viewModel = viewModel,
            moleNumStatus = viewModel.moleout4.value)
        CustomBox(
            viewModel = viewModel,
            moleNumStatus = viewModel.moleout5.value)
        CustomBox(
            viewModel = viewModel,
            moleNumStatus = viewModel.moleout6.value)
    }
    //ThirdRow
    Row(modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter).height(150.dp)) {
        CustomBox(
            viewModel = viewModel,
            moleNumStatus = viewModel.moleout7.value)
        CustomBox(
            viewModel = viewModel,
            moleNumStatus = viewModel.moleout8.value)
        CustomBox(
            viewModel = viewModel,
            moleNumStatus = viewModel.moleout9.value)
    }
}

@Composable
fun RowScope.CustomBox(viewModel: MainViewModel, moleNumStatus: Boolean) {
    Box(
        modifier = Modifier
            .clip(shape = CircleShape)
            .weight(1f)
            .fillMaxSize()
            .padding(top = 8.dp, bottom = 8.dp, start = 4.dp, end = 4.dp),
        contentAlignment = Alignment.BottomCenter

    ) {
        Image(
            painter = painterResource(viewModel.molein),
            contentDescription = "",
            modifier = Modifier.fillMaxWidth().height(66.dp),
            contentScale = ContentScale.FillBounds
        )
        if (moleNumStatus) {
            Image(
                painter = painterResource(viewModel.moleout),
                contentDescription = "",
                modifier = Modifier.fillMaxWidth().height(100.dp)
                    .clickable { viewModel._score.value += 1}  ,
                contentScale = ContentScale.FillBounds
            )
        }
    }
}



