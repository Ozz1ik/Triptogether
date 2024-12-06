package com.example.travelapp.components

import android.content.Context
import android.content.SharedPreferences
import com.example.travelapp.screens.Trip

class SharedPreferencesHelper(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("travel_app_prefs", Context.MODE_PRIVATE)

    // Ключи для SharedPreferences
    private val TRIPS_KEY = "trips_key"

    // Сохранение списка поездок
    fun saveTrips(trips: List<Trip>) {
        val tripsJson = trips.joinToString(",") { "${it.destination}:${it.duration}:${it.numberOfPeople}" }
        sharedPreferences.edit().putString(TRIPS_KEY, tripsJson).apply()
    }

    // Получение списка поездок
    fun getTrips(): List<Trip> {
        val tripsJson = sharedPreferences.getString(TRIPS_KEY, "")
        return if (!tripsJson.isNullOrEmpty()) {
            tripsJson.split(",").map {
                val tripData = it.split(":")
                Trip(
                    destination = tripData[0],
                    duration = tripData[1].toInt(),
                    numberOfPeople = tripData[2].toInt()
                )
            }
        } else {
            emptyList()
        }
    }
}
