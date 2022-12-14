package com.vrk.weatherinfo.data

data class WeatherReport(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<WeatherList>,
    val message: Int
)