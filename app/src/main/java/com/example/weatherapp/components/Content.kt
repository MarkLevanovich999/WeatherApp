package com.example.weatherapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.weatherapp.R
import com.example.weatherapp.data.WeatherData
import com.example.weatherapp.ui.theme.LightBlue

@Composable
fun Content(forecastlist: MutableState<WeatherData>) {

    Row(
        modifier = Modifier.padding(top = 50.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        AsyncImage(
            model = "https:" + forecastlist.value.currentIcon,
            contentDescription = null,
            modifier = Modifier
                .size(height = 64.dp, width = 64.dp)
        )

        Text(
            text = forecastlist.value.currentTemp.substringBefore(".") + "°C",
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(start = 5.dp)
        )

    }

    Text(
        text = forecastlist.value.condition,
        fontSize = 18.sp,
        fontWeight = FontWeight.Light,
        color = LightBlue
    )

    Divider(
        color = Color.White,
        thickness = 2.dp,
        modifier = Modifier
            .width(50.dp)
            .padding(top = 40.dp)
    )

}