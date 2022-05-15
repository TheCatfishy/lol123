package com.gss.restExample.service


import com.gss.interfaces.service.ExampleService
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import restExample.service.Coordinate
import restExample.service.cleanWeatherPrediction
import restExample.service.getCoordinateFromCountry
import restExample.service.getWeatherPrediction


@Component
class ExampleServiceImpl : ExampleService  {

    constructor()


    override fun ping() : String? {
        return "pong"
    }


    override fun getWeatherToday(language: String, country: String): String? {
        val coordinate: Coordinate? = getCoordinateFromCountry(country)
        val weatherPrediction = getWeatherPrediction(coordinate, 0)
        return cleanWeatherPrediction(weatherPrediction, language)
    }

    override fun getWeatherTomorrow(language: String, country: String): String? {
        val coordinate: Coordinate? = getCoordinateFromCountry(country)
        val weatherPrediction = getWeatherPrediction(coordinate, 1)
        return cleanWeatherPrediction(weatherPrediction, language)
    }

    override fun getWeather2DaysAhead(language: String, country: String): String? {
        val coordinate: Coordinate? = getCoordinateFromCountry(country)
        val weatherPrediction = getWeatherPrediction(coordinate, 2)
        return cleanWeatherPrediction(weatherPrediction, language)
    }

    override fun getWeather3DaysAhead(language: String, country: String): String? {
        val coordinate: Coordinate? = getCoordinateFromCountry(country)
        val weatherPrediction = getWeatherPrediction(coordinate, 3)
        return cleanWeatherPrediction(weatherPrediction, language)
    }

    override fun getWeather4DaysAhead(language: String, country: String): String? {
        val coordinate: Coordinate? = getCoordinateFromCountry(country)
        val weatherPrediction = getWeatherPrediction(coordinate, 4)
        return cleanWeatherPrediction(weatherPrediction, language)
    }

    override fun getWeather5DaysAhead(language: String, country: String): String? {
        val coordinate: Coordinate? = getCoordinateFromCountry(country)
        val weatherPrediction = getWeatherPrediction(coordinate, 5)
        return cleanWeatherPrediction(weatherPrediction, language)
    }

    override fun getWeather6DaysAhead(language: String, country: String): String? {
        val coordinate: Coordinate? = getCoordinateFromCountry(country)
        val weatherPrediction = getWeatherPrediction(coordinate, 6)
        return cleanWeatherPrediction(weatherPrediction, language)
    }
}
