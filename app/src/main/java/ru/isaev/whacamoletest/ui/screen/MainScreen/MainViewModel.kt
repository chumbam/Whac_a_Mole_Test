package ru.isaev.whacamoletest.ui.screen.MainScreen

import android.os.CountDownTimer
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.isaev.whacamoletest.GameScreenItem
import ru.isaev.whacamoletest.R
import kotlin.random.Random


class MainViewModel(navController: NavHostController) : ViewModel() {
    var _moleout1 = mutableStateOf(false)
    var moleout1: State<Boolean> = _moleout1

    var _moleout2 = mutableStateOf(false)
    val moleout2: State<Boolean> = _moleout2

    var _moleout3 = mutableStateOf(false)
    val moleout3: State<Boolean> = _moleout3

    var _moleout4 = mutableStateOf(false)
    val moleout4: State<Boolean> = _moleout4

    var _moleout5 = mutableStateOf(false)
    val moleout5: State<Boolean> = _moleout5

    var _moleout6 = mutableStateOf(false)
    val moleout6: State<Boolean> = _moleout6

    var _moleout7 = mutableStateOf(false)
    val moleout7: State<Boolean> = _moleout1

    var _moleout8 = mutableStateOf(false)
    val moleout8: State<Boolean> = _moleout8

    var _moleout9 = mutableStateOf(false)
    val moleout9: State<Boolean> = _moleout9

    var _timer = mutableStateOf(30)
    val timer: State<Int> = _timer

    var _score = mutableStateOf(0)
    val score: State <Int> = _score


    val moleout = R.drawable.molehole
    val molein = R.drawable.holemust

    val list = mutableListOf(
        _moleout1,
        _moleout2,
        _moleout3,
        _moleout4,
        _moleout5,
        _moleout6,
        _moleout7,
        _moleout8,
        _moleout9
    )


    fun startGame() {
        val timer = object : CountDownTimer(30000, 1000) {
            override fun onTick(p0: Long) {
                getRandomHole(list = list)
                _timer.value = (p0/1000).toInt()

            }

            override fun onFinish() {
                _timer.value = 30

            }

        }
        timer.start()


    }

    fun getRandomHole(list: MutableList<MutableState<Boolean>>) {
        viewModelScope.launch {
            val rand = Random.nextInt(7)
            list[rand].value = !list[rand].value
            println(list[rand].value)
            delay(600)
            list[rand].value = !list[rand].value
            println(list[rand].value)
        }
    }

    fun EndGame(navController: NavHostController){
        navController.navigate(route = GameScreenItem.ScoreScreen.route)
    }


}
