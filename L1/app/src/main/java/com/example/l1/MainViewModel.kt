package com.example.l1

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    val firstNumberInput = mutableStateOf<String>("")
    val secondNumberInput = mutableStateOf<String>("")
    val difference = mutableStateOf<Int?>(null)

    fun calculateDifference() {
        try {
            val firstNumber = firstNumberInput.value.toInt()
            val secondNumber = secondNumberInput.value.toInt()

            difference.value = firstNumber - secondNumber
        } catch (e: Exception) {
            // ignore
        }
    }

    fun setFirstNumberInput(value: String) {
        firstNumberInput.value = value
    }

    fun setSecondNumberInput(value: String) {
        secondNumberInput.value = value
    }
}
