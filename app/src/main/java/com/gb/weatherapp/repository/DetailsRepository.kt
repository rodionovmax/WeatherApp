package com.gb.weatherapp.repository

import com.gb.weatherapp.model.WeatherDTO
import okhttp3.Callback

interface DetailsRepository {
    fun getWeatherDetailsFromServer(
        lat: Double,
        lon: Double,
        callback: retrofit2.Callback<WeatherDTO>
    )
}