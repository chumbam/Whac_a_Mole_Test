package ru.isaev.whacamoletest.heplers

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf

object ViewState {
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
}