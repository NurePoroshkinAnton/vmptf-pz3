package com.example.l1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.l1.ui.components.NumberDifferenceForm
import com.example.l1.ui.theme.L1Theme
import androidx.compose.material3.Text
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            L1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp), verticalArrangement = Arrangement.Center) {
                        if (mainViewModel.difference.value != null) {
                            Text(text = "Difference: ${mainViewModel.difference.value}", fontSize = 26.sp)
                            Spacer(modifier = Modifier.height(20.dp))
                        }

                        NumberDifferenceForm(
                            firstNumberInput = mainViewModel.firstNumberInput.value,
                            secondNumberInput = mainViewModel.secondNumberInput.value,
                            onFirstNumberChange = { value ->  mainViewModel.setFirstNumberInput(value) },
                            onSecondNumberChange = { value ->  mainViewModel.setSecondNumberInput(value) },
                            onSubmit = { mainViewModel.calculateDifference() }
                        )
                    }
                }
            }
        }
    }
}