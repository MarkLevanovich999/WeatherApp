package com.example.weatherapp.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R
import com.example.weatherapp.data.WeatherData
import com.example.weatherapp.ui.theme.LightBlue

@Composable
fun InfoBox(item: String, heading: String, image: String) {

    Box(
        modifier = Modifier
            .width(110.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(
                    LocalContext.current.resources.getIdentifier(
                            image,
                            "drawable",
                            LocalContext.current.packageName
                        )
                ),
                contentDescription = null,
                modifier = Modifier.size(height = 50.dp, width = 50.dp)
            )

            Text(
                text = heading,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White,
                modifier = Modifier.padding(top = 10.dp)
            )

            Text(
                text = item,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = LightBlue
            )

        }
    }

}