package com.example.travelapp

import android.app.Application
import com.yandex.mapkit.MapKitFactory

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // Инициализация MapKit с использованием API-ключа
        MapKitFactory.setApiKey(BuildConfig.MAPKIT_API_KEY)
    }
}
