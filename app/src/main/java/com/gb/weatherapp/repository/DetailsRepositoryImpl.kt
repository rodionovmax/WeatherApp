package com.gb.weatherapp.repository

import com.gb.weatherapp.model.WeatherDTO

class DetailsRepositoryImpl(private val remoteDataSource: RemoteDataSource) :
    DetailsRepository {
    override fun getWeatherDetailsFromServer(
        lat: Double,
        lon: Double,
        callback: retrofit2.Callback<WeatherDTO>
    ) {
        remoteDataSource.getWeatherDetails(lat, lon, callback)
    }
}