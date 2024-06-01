package com.example.l2.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.l2.ui.components.GameCard
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.l2.ui.components.GameResultDialog

@Composable
fun MainScreen(mainViewModel: MainViewModel = viewModel()) {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Guess the number (${mainViewModel.currentNumber})",
            style = typography.titleLarge,
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            GameCard(userGuess = mainViewModel.userGuess,
                isGuessWrong = mainViewModel.isUserGuessWrong,
                onUserGuessChanged = { mainViewModel.updateUserGuess(it) })

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { mainViewModel.checkUserGuess() }
            ) {
                Text(
                    "Make a guess",
                    fontSize = 16.sp
                )
            }
        }
    }

    if (mainViewModel.isGameOver) {
        GameResultDialog(onPlayAgain = { mainViewModel.resetGame() })
    }
}