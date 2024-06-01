package com.example.l1.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NumberDifferenceForm(
    firstNumberInput: String,
    secondNumberInput: String,
    onFirstNumberChange: (value: String) -> Unit,
    onSecondNumberChange: (value: String) -> Unit,
    onSubmit: () -> Unit
) {
    Column() {
        OutlinedTextField(
            value = firstNumberInput,
            onValueChange = { value -> onFirstNumberChange(value) },
            label = { Text("First number") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = secondNumberInput,
            onValueChange = { value -> onSecondNumberChange(value) },
            label = { Text(text = "Second number") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { onSubmit() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calculate difference")
        }
    }
}