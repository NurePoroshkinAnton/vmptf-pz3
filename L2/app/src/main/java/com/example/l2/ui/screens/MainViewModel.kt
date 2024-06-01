package com.example.l2.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

const val MIN_GUESS_VALUE = 1
const val MAX_GUESS_VALUE = 100

class MainViewModel: ViewModel() {
    var userGuess by mutableStateOf<String>("")
        private set
    var currentNumber: Int = 0
        private set
    var isUserGuessWrong by mutableStateOf<Boolean>(false)
        private set
    var isGameOver by mutableStateOf<Boolean>(false)
        private set

    init {
        resetGame()
    }

    fun resetGame() {
        currentNumber = (MIN_GUESS_VALUE..MAX_GUESS_VALUE).random()
        isUserGuessWrong = false
        isGameOver = false
        userGuess = ""
    }

    fun checkUserGuess() {
        val parsedGuess = userGuess.toIntOrNull() ?: return
        if (parsedGuess == currentNumber) {
            isGameOver = true
            isUserGuessWrong = false
        } else {
            isUserGuessWrong = true
        }
    }

    fun updateUserGuess(value: String) {
        userGuess = value
    }
}