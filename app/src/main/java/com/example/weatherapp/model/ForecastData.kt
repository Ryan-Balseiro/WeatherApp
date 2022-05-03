package com.example.weatherapp.model

data class ForecastData(
    val city: ForecastCity,
    val cnt: Int,
    val cod: String,
    val list: List<Data>,
    val message: Int
)

data class Data(
    val clouds: Clouds,
    val dt: Int,
    val dt_txt: String,
    val main: Main,
    val pop: Double,
    val rain: ForecastRain,
    val sys: Sys,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
)

data class ForecastCoord(
    val lat: Double,
    val lon: Double
)
data class ForecastWind(
    val deg: Int,
    val gust: Double,
    val speed: Double
)
data class ForecastCity(
    val coord: Coord,
    val country: String,
    val id: Int,
    val name: String,
    val population: Int,
    val sunrise: Int,
    val sunset: Int,
    val timezone: Int
)

data class ForecastRain(
    val `3h`: Double
)

data class ForecastMain(
    val feels_like: Double,
    val grnd_level: Int,
    val humidity: Int,
    val pressure: Int,
    val sea_level: Int,
    val temp: Double,
    val temp_kf: Double,
    val temp_max: Double,
    val temp_min: Double
)

data class ForecastSys(
    val pod: String
)

data class ForecastClouds(
    val all: Int
)

data class ForecastWeather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)