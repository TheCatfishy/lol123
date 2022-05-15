package restExample.service

import org.json.JSONObject
import java.math.BigDecimal
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.time.Duration


fun getCoordinateFromCountry(country: String): Coordinate? {
    if (country == "Niamey") {
        return Coordinate(13.5116, 2.1254)
    } else if (country == "Arlit") {
        return Coordinate(18.7390, 7.3895)
    } else if (country == "Chad") {
        return Coordinate(13.8018, 8.9853)
    } else if (country == "Bogande") {
        return Coordinate(12.96,-0.15)
    } else if (country == "Bousse") {
        return Coordinate(12.6, -1.89)
    } else if (country == "Ouagadougou") {
        return Coordinate(12.36566, -1.53388)
    } else if (country == "Mbaiki") {
        return Coordinate(3.86781, 17.98923)
    } else if (country == "Paoua") {
        return Coordinate(7.24269, 16.44059)
    } else if (country == "Bria") {
        return Coordinate(6.54233, 21.98633)
    } else if (country == "NDjamena") {
        return Coordinate(12.10672, 15.0444)
    } else if (country == "Sarh") {
        return Coordinate(9.1429, 18.3923)
    } else if (country == "Ngama") {
        return Coordinate(11.78333, 17.16667)
    } else if (country == "Mamou") {
        return Coordinate(10.37546, -12.09148)
    } else if (country == "Boke") {
        return Coordinate(10.93217, -14.29055)
    } else if (country == "Boffa") {
        return Coordinate(10.1808, 14.0392)
    } else if (country == "Koutiala") {
        return Coordinate(12.39173, -5.46421)
    } else if (country == "Sikasso") {
        return Coordinate(11.31755, -5.66654)
    } else if (country == "Yorosso") {
        return Coordinate(12.35811, -4.77688)
    } else if (country == "Maputo") {
        return Coordinate(-25.96553, 32.58322)
    } else if (country == "Beira") {
        return Coordinate(-19.84361, 34.83889)
    } else if (country == "Nampula") {
        return Coordinate(-15.11646, 39.2666)
    } else if (country == "Juba") {
        return Coordinate(4.85165, 31.58247)
    } else if (country == "Malakal") {
        return Coordinate(9.53342, 31.66049)
    } else if (country == "Winejok") {
        return Coordinate(9.01222, 27.57081)
    } else if (country == "Asmara") {
        return Coordinate(15.33805, 38.93184)
    } else if (country == "Massawa") {
        return Coordinate(15.60811, 39.47455)
    } else if (country == "Medefera") {
        return Coordinate(14.88722, 38.81528)
    } else {
        return null
    }
}

fun getWeatherPrediction(coordinate: Coordinate?, day: Int): Weather? {
    if (coordinate == null) {
        return null
    }
    val client = HttpClient.newBuilder()
        .version(HttpClient.Version.HTTP_1_1)
        .followRedirects(HttpClient.Redirect.NORMAL)
        .connectTimeout(Duration.ofSeconds(20))
        .build()
    val baseUrl: String =
        "https://api.open-meteo.com/v1/forecast?latitude=${coordinate.latitude}&longitude=${coordinate.longitude}&daily=weathercode,temperature_2m_max,temperature_2m_min,precipitation_sum,precipitation_hours,windspeed_10m_max,winddirection_10m_dominant,shortwave_radiation_sum&timezone=Europe%2FBerlin"
    println(baseUrl)
    var request: HttpRequest = HttpRequest.newBuilder()
        .uri(URI.create(baseUrl))
        .timeout(Duration.ofMinutes(1))
        .GET()
        .build()
    var response = client.send(request, HttpResponse.BodyHandlers.ofString())
    var jsonObject = JSONObject(response.body())
    println(jsonObject)
    jsonObject = jsonObject.getJSONObject("daily")
    println(jsonObject)
    println(jsonObject.getJSONArray("windspeed_10m_max"))
    println(jsonObject.getJSONArray("windspeed_10m_max").get(day))

    var givenPrediction: Weather? = Weather()
    if (givenPrediction != null) {
        givenPrediction.windspeed_10m_max = jsonObject.getJSONArray("windspeed_10m_max").get(day) as Object?
        givenPrediction.winddirection_10m_dominant = jsonObject.getJSONArray("winddirection_10m_dominant").get(day) as Object?
        givenPrediction.precipitation_sum = jsonObject.getJSONArray("precipitation_sum").get(day) as Object?
        givenPrediction.temperature_2m_max = jsonObject.getJSONArray("temperature_2m_max").get(day) as Object?
        givenPrediction.precipitation_hours = jsonObject.getJSONArray("precipitation_hours").get(day) as Object?
        givenPrediction.temperature_2m_min = jsonObject.getJSONArray("temperature_2m_min").get(day) as Object?
        givenPrediction.shortwave_radiation_sum = jsonObject.getJSONArray("shortwave_radiation_sum").get(day) as Object?
    }
    return givenPrediction
}

fun getWindTextEnglish(weather: Weather?): String? {
    if (weather != null) {
        return "<prompt>\n" + "The wind has a maximum of " + weather.windspeed_10m_max.toString() + " kilometer per hours in a direction of " + weather.winddirection_10m_dominant.toString() + " degrees." +
                " It will rain " + weather.precipitation_sum.toString() + " milimeter over " + weather.precipitation_hours.toString() + " hours." +
                " The minimum temperature is " + weather.temperature_2m_min.toString() + " celcius and a maximum of " + weather.temperature_2m_max.toString()+ " celcius." +
                " And there is a total of " + weather.shortwave_radiation_sum.toString() + " mega jules of sun per square meters." + "\n" + "</prompt>\n"
    } else {
        return null
    }
}

fun getWindTextFrench(weather: Weather?): String? {
    if (weather != null) {
        return "<prompt xml:lang=\"fr-FR\">\n" + "Le vent a un maximum de  " + weather.windspeed_10m_max.toString() + " kilomètres par heure dans une direction de" + weather.winddirection_10m_dominant.toString() + " degrés." +
                " Il pleuvra " + weather.precipitation_sum.toString() + " millimètre sur " + weather.precipitation_hours.toString() + " heures." +
                " La température minimale est de " + weather.temperature_2m_min.toString() + " degrés Celsius et maximale de " + weather.temperature_2m_max.toString()+ " degrés Celsius." +
                " Et il y a un total de " + weather.shortwave_radiation_sum.toString() + " méga jules de soleil par mètre carré." + "\n" + "</prompt>\n"
    } else {
        return null
    }
}

fun cleanWeatherPrediction(weather: Weather?, language: String): String? {
    if (weather == null) {
        return "something went wrong"
    }
    if(language == "English")
        return getWindTextEnglish(weather)
    if(language == "French")
        return getWindTextFrench(weather)
    return null
}
