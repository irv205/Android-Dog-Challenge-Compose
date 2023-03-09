package com.kk.dogchallengecompose.ui.main

sealed class MainViewState {
    object Idle : MainViewState()
    class Success(val img: String) : MainViewState()
    class Error(val message: String): MainViewState()
}