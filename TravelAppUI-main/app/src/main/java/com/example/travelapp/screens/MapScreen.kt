package com.example.travelapp.screens

import android.os.Bundle
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView
import com.yandex.mapkit.map.PlacemarkMapObject
import com.yandex.mapkit.geometry.Point
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.DisposableEffect
@Composable
fun MapScreen(onBackPressed: () -> Unit) {
    // Инициализация MapKit
    val context = LocalContext.current
    LaunchedEffect(context) {
        MapKitFactory.initialize(context)
    }

    // Добавление верхней панели с кнопкой возврата
    TopAppBar(
        title = { Text("Map", style = MaterialTheme.typography.h6) },
        navigationIcon = {
            IconButton(onClick = onBackPressed) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back"
                )
            }
        },
        backgroundColor = MaterialTheme.colors.primarySurface,
        contentColor = Color.White
    )

    // Карта
    MapViewComposable()
}

@Composable
fun MapViewComposable() {
    val context = LocalContext.current
    val mapView = MapView(context)

    // Настройка карты
    val map = mapView.map // Получаем объект карты

    val location = Point(55.751225, 37.62954) // Координаты Москвы
    map.move(
        CameraPosition(location, 17f, 150f, 30f) // Задаем масштаб и ориентацию
    )

    val placemark: PlacemarkMapObject = map.mapObjects.addPlacemark(location)
    placemark.setOpacity(0.5f) // Устанавливаем прозрачность маркера

    // Размещение карты на экране
    AndroidView(
        factory = { mapView },
        modifier = Modifier.fillMaxSize(),
        update = { mapView ->
            // При изменении жизненного цикла Activity нужно вызывать onStart() и onStop()
            mapView.onStart()
        }
    )

    // Управление жизненным циклом карты
    DisposableEffect(context) {
        onDispose {
            mapView.onStop() // Правильный вызов onStop при разрушении компонента
        }
    }
}
