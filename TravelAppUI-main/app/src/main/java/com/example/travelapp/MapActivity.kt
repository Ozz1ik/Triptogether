package com.example.travelapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.mapview.MapView

class MapActivity : AppCompatActivity() {

    private lateinit var mapView: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Инициализация MapKit
        MapKitFactory.setApiKey(BuildConfig.MAPKIT_API_KEY)  // Использование API-ключа
        MapKitFactory.initialize(this)

        // Установка контента для активности
        setContentView(R.layout.activity_map)

        // Инициализация MapView
        mapView = findViewById(R.id.mapview)

        // Перемещение камеры на координаты Санкт-Петербурга
        moveCameraToPoint(Point(59.934280, 30.335098)) // Санкт-Петербург, координаты
    }

    // Функция для перемещения камеры
    private fun moveCameraToPoint(point: Point) {
        // Используйте mapWindow для доступа к объектам карты
        mapView.mapWindow.map.move(
            CameraPosition(
                point,    // Новая позиция
                17.0f,    // Увеличение (zoom)
                150.0f,   // Азимут (rotation)
                30.0f     // Наклон (tilt)
            )
        )
    }

    override fun onStart() {
        super.onStart()
        // Обработка старта MapKit
        MapKitFactory.getInstance().onStart()
        mapView.onStart()
    }

    override fun onStop() {
        super.onStop()
        // Обработка остановки MapKit
        mapView.onStop()
        MapKitFactory.getInstance().onStop()
    }
}

