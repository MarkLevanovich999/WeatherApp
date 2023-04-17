package com.example.weatherapp.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R

val Numans = FontFamily(
    Font(R.font.numans)
)

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = Numans,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)

