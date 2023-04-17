package com.example.weatherapp.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.weatherapp.data.WeatherData
import com.example.weatherapp.ui.theme.LightBlue

@Composable
fun ForecastDay(day: WeatherData) {

    Box(
        modifier = Modifier
            .width(80.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            AsyncImage(
                model = "https:${ day.icon }",
                contentDescription = null,
                modifier = Modifier
                    .size(height = 64.dp, width = 64.dp)
            )

            Text(
                text = day.date
                    .substringAfter("-")
                    .substringAfter("-") + " / " +
                    day.date.substringAfter("-").substringBefore("-"),
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = LightBlue,
                modifier = Modifier.padding(top = 2.dp)
            )

            Text(
                text = "${ day.temp.substringAfter(".") }°C",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White,
                modifier = Modifier.padding(top = 2.dp)
            )

        }
    }

}