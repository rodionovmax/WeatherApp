package com.gb.weatherapp.repository

import com.gb.weatherapp.model.Weather
import com.gb.weatherapp.model.getRussianCities
import com.gb.weatherapp.model.getWorldCities

class MainRepositoryImpl : MainRepository {

    override fun getWeatherFromServer() = Weather()

    override fun getWeatherFromLocalStorageRus() = getRussianCities()

    override fun getWeatherFromLocalStorageWorld() = getWorldCities()
}

