package com.example.travelapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

// Модель Trip
data class Trip(
    val destination: String,
    val duration: Int,
    val numberOfPeople: Int
)

@Composable
fun CreateTripScreen(navController: NavController, onSaveTrip: (Trip) -> Unit) {
    var destination by remember { mutableStateOf("") }
    var duration by remember { mutableStateOf("") }
    var numberOfPeople by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") } // Для отображения ошибки, если данные не введены

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Создать своё путешествие",
            style = MaterialTheme.typography.h5
        )

        OutlinedTextField(
            value = destination,
            onValueChange = { destination = it },
            label = { Text("Пункт назначения") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = duration,
            onValueChange = { duration = it },
            label = { Text("Длительность (в днях)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = numberOfPeople,
            onValueChange = { numberOfPeople = it },
            label = { Text("Количество людей") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        // Если есть ошибка, показываем текст
        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colors.error,
                style = MaterialTheme.typography.body2
            )
        }

        Button(
            onClick = {
                // Проверяем, что все поля заполнены
                if (destination.isNotEmpty() && duration.isNotEmpty() && numberOfPeople.isNotEmpty()) {
                    val trip = Trip(
                        destination = destination,
                        duration = duration.toInt(),
                        numberOfPeople = numberOfPeople.toInt()
                    )
                    onSaveTrip(trip) // Сохраняем путешествие через callback
                    navController.popBackStack() // Возвращаемся назад
                } else {
                    errorMessage = "Пожалуйста, заполните все поля" // Уведомление об ошибке
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Подтвердить")
        }
    }
}
