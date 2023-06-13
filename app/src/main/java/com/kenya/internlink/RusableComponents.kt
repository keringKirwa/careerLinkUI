package com.kenya.internlink

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.kenya.internlink.ui.theme.PrimaryColor

@Composable
fun CustomTitle(text : String) {
    Text(
        text = text,
        fontSize = 20.sp,
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.ExtraBold,
        color = PrimaryColor
    )

}