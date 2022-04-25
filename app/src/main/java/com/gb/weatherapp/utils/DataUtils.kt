package com.gb.weatherapp.utils

import com.gb.weatherapp.model.FactDTO
import com.gb.weatherapp.model.Weather
import com.gb.weatherapp.model.WeatherDTO
import com.gb.weatherapp.model.getDefaultCity

fun convertDtoToModel(weatherDTO: WeatherDTO): List<Weather> {
    val fact: FactDTO = weatherDTO.fact!!
    return listOf(Weather(getDefaultCity(), fact.temp!!, fact.feels_like!!, fact.condition!!, fact.icon))
}
