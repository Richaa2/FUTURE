package com.richa.future.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.richa.future.R
import com.richa.future.ui.theme.MyFontHolder.myFontFamily

object MyFontHolder {
    val myFontFamily = FontFamily(Font(R.font.encodesans))
}

val regularTextStyle = TextStyle(
    fontSize = 14.sp,
    lineHeight = 24.sp,
    fontFamily = FontFamily(Font(R.font.encodesans)),
    fontWeight = FontWeight(400),
    color = darkSlateGray,
    letterSpacing = 0.42.sp,
)

val mediumTextStyle = TextStyle(
    fontSize = 16.sp,
    lineHeight = 20.sp,
    fontFamily = FontFamily(Font(R.font.encodesans)),
    fontWeight = FontWeight(500),
    color = darkSlateGray,
)

val semiBoldStyle = TextStyle(
    fontSize = 24.sp,
    lineHeight = 48.sp,
    fontFamily = FontFamily(Font(R.font.encodesans)),
    fontWeight = FontWeight(600),
    color = darkSlateGray,

    )

val boldStyle = TextStyle(
    fontSize = 36.sp,
    lineHeight = 48.sp,
    fontFamily = FontFamily(Font(R.font.encodesans)),
    fontWeight = FontWeight(700),
    color = darkSlateGray,

    )

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = mediumTextStyle
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)
