package com.example.travelapp  // Убедитесь, что пакет совпадает с вашим

import android.app.Application
import com.yandex.mapkit.MapKitFactory

class Application : Application() {

    override fun onCreate() {
        super.onCreate()

        // Инициализация MapKit с использованием API-ключа
        MapKitFactory.setApiKey(BuildConfig.MAPKIT_API_KEY)
    }
}
