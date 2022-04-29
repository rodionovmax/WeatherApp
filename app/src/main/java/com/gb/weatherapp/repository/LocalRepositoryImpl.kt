package com.gb.weatherapp.repository

import com.gb.weatherapp.model.Weather
import com.gb.weatherapp.model.room.HistoryDao
import com.gb.weatherapp.utils.convertHistoryEntityToWeather
import com.gb.weatherapp.utils.convertWeatherToEntity

class LocalRepositoryImpl(private val localDataSource: HistoryDao) : LocalRepository {
    override fun getAllHistory(): List<Weather> {
        return convertHistoryEntityToWeather(localDataSource.all())
    }

    override fun saveEntity(weather: Weather) {
        localDataSource.insert(convertWeatherToEntity(weather))
    }
}