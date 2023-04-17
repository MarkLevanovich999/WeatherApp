package com.example.weatherapp.data

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.weatherapp.components.ForecastDay
import org.json.JSONArray
import org.json.JSONObject


val API_KEY = "c5807359643d4399ab0105551233103"

fun GetData(
    location: String,
    day: Int,
    context: Context,
    forecastlist: MutableState<WeatherData>,
    listOfLists: MutableList<List<WeatherData>>
) {

    val url = "https://api.weatherapi.com/v1/forecast.json?" +
            "key=$API_KEY" +
            "&q=$location" +
            "&days=$day" +
            "&aqi=no" +
            "&alerts=no"

    val queue = Volley.newRequestQueue(context)

    val request = StringRequest(
        Request.Method.GET,
        url,
        { response ->
            val list = getForecast(response,0)
            forecastlist.value = list[0]

            listOfLists.add(list)

            for (i in 1 until day) {

                var index = i

                val list = getForecast(response,index)

                listOfLists.add(list)

            }

        },
        null
    )

    queue.add(request)


}

fun getForecast(response: String, i: Int): List<WeatherData> {

    val forecastlist = ArrayList<WeatherData>()

    val WeatherObject = JSONObject(response)
    val forecastObject = WeatherObject.getJSONObject("forecast")
    val daysArray = forecastObject.getJSONArray("forecastday")

    for(i in 0 until daysArray.length()) {
        val day = daysArray[i] as JSONObject

        forecastlist.add(
            WeatherData(
                // location
                WeatherObject.getJSONObject("location").getString("name"),
                // currentTime
                WeatherObject.getJSONObject("location").getString("localtime"),
                // currentTemp
                WeatherObject.getJSONObject("current").getString("temp_c"),
                // condition
                WeatherObject.getJSONObject("current").getJSONObject("condition").getString("text"),
                // speedWind
                WeatherObject.getJSONObject("current").getString("wind_mph"),
                // currentIcon
                WeatherObject.getJSONObject("current").getJSONObject("condition").getString("icon"),
                // sunrise
                day.getJSONObject("astro").getString("sunrise"),
                // temp
                day.getJSONObject("day").getString("maxtemp_c"),
                // date
                day.getString("date"),
                // icon
                day.getJSONObject("day").getJSONObject("condition").getString("icon")
            )
        )

    }


    forecastlist[0] = forecastlist[i].copy(
        currentTime = WeatherObject.getJSONObject("current").getString("last_updated"),
        currentTemp = WeatherObject.getJSONObject("current").getString("temp_c"),
    )

    return forecastlist

}