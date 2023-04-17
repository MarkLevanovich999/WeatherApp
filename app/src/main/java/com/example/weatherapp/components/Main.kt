package com.example.weatherapp.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.weatherapp.data.GetData
import com.example.weatherapp.data.WeatherData
import com.example.weatherapp.data.getForecast
import com.example.weatherapp.ui.theme.BackGround
import com.example.weatherapp.ui.theme.WeatherAppTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@Composable
fun Main(forecastlist: MutableState<WeatherData>, listOfLists: MutableList<List<WeatherData>>) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(ScrollState(0)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Header(forecastlist)
        Content(forecastlist)

        Column(
            modifier = Modifier
                .padding(top = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, start = 15.dp)
            ) {

                val sunrise = forecastlist.value.sunrise.substringBefore(" ")
                val speedWind = forecastlist.value.speedWind + "m/s"
                val temp = forecastlist.value.temp + "°C"


                InfoBox(sunrise, "SUNRISE", "sunrise")

                Divider(
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp)
                        .height(70.dp)
                        .padding(top = 30.dp)
                )

                InfoBox(temp, "MAXTEMP","temp")

                Divider(
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp)
                        .height(70.dp)
                        .padding(top = 30.dp)
                )

                InfoBox(speedWind, "WIND", "wind")

            }

            Text(
                text = "Forecast days",
                fontSize = 20.sp,
                fontWeight = FontWeight.Light,
                color = Color.White,
                modifier = Modifier.padding(top = 50.dp)
            )

            Row(
                modifier = Modifier.padding(top = 10.dp)
            ) {

                for (day in listOfLists) {

                    ForecastDay(day[0])

                }

            }

        }

    }

}