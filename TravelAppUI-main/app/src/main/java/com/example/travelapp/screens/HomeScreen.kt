package com.example.travelapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.travelapp.R
import com.example.travelapp.components.PlaceCard
import com.example.travelapp.navigation.Routes

@Composable
fun HomeScreen(goToPlace: (String) -> Unit, goToCreateTrip: () -> Unit, trips: List<Trip>, selectTrip: (Trip) -> Unit) {
    Column(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        // Существующие PlaceCard (фиксированные путешествия) с кнопкой выбора под каждым
        // Для Бали
        PlaceCard(
            image = R.drawable.bali_cover,
            place = R.string.place_1,
            price = "$999",
            plan = "Super Saver",
            noOfDays = 7,
            noOfPersons = 2,
            onClick = { goToPlace(Routes.Bali.name) }
        )
        Button(
            onClick = { selectTrip(Trip("Бали", 7, 2)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .height(48.dp)
        ) {
            Text(text = "Выбрать Бали")
        }

        // Для Парижа
        PlaceCard(
            image = R.drawable.paris_cover,
            place = R.string.place_2,
            price = "$1299",
            plan = "Super Saver",
            noOfDays = 7,
            noOfPersons = 2,
            onClick = { goToPlace(Routes.Paris.name) }
        )
        Button(
            onClick = { selectTrip(Trip("Париж", 7, 2)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .height(48.dp)
        ) {
            Text(text = "Выбрать Париж")
        }

        // Для Сингапура
        PlaceCard(
            image = R.drawable.singapore_cover,
            place = R.string.place_3,
            price = "$888",
            plan = "Super Saver",
            noOfDays = 7,
            noOfPersons = 2,
            onClick = { goToPlace(Routes.Singapore.name) }
        )
        Button(
            onClick = { selectTrip(Trip("Сингапур", 7, 2)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .height(48.dp)
        ) {
            Text(text = "Выбрать Сингапур")
        }

        // Отображение списка путешествий, созданных пользователем
        trips.forEach { trip ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                elevation = 4.dp
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Пункт назначения: ${trip.destination}", style = MaterialTheme.typography.h6)
                    Text(text = "Длительность: ${trip.duration} дней")
                    Text(text = "Количество людей: ${trip.numberOfPeople}")
                }
            }
        }

        // Добавление кнопки для создания путешествия
        Button(
            onClick = { goToCreateTrip() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .height(48.dp)
        ) {
            Text(text = "Создать своё путешествие")
        }
    }
}
