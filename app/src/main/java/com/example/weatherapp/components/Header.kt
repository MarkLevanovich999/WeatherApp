package com.example.weatherapp.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.data.WeatherData
import com.example.weatherapp.ui.theme.BackGround
import com.example.weatherapp.ui.theme.LightBlue

@Composable
fun Header(forecastList: MutableState<WeatherData>) {

    Column(
        modifier = Modifier.padding(top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = forecastList.value.location,
            fontSize = 30.sp,
            fontWeight = FontWeight.Light,
            color = Color.White,
            modifier = Modifier.padding(top = 20.dp)
        )

        Text(
            text = forecastList.value.currentTime.substringAfter(" "),
            fontSize = 14.sp,
            fontWeight = FontWeight.ExtraLight,
            color = LightBlue
        )

    }

}