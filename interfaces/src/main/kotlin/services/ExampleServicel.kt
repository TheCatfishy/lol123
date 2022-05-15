package com.gss.interfaces.service

interface ExampleService {

    fun ping() : String?

    fun getWeatherToday(language: String, country: String) : String?

    fun getWeatherTomorrow(language: String, country: String) : String?

    fun getWeather2DaysAhead(language: String, country: String) : String?

    fun getWeather3DaysAhead(language: String, country: String): String?

    fun getWeather4DaysAhead(language: String, country: String): String?

    fun getWeather5DaysAhead(language: String, country: String): String?

    fun getWeather6DaysAhead(language: String, country: String): String?

}