package com.kenya.internlink.helpers

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kenya.internlink.R
import com.kenya.internlink.screens.one_oppotunity.CustomText
import com.kenya.internlink.ui.theme.PoppinsFontFamily
import com.kenya.internlink.ui.theme.PrimaryColor

@Composable
fun EasyText(text : String) {
    Text(
        text = text,
        fontSize = 15.sp,
        fontFamily = FontFamily.SansSerif,
        color = Color.Black,
        modifier = Modifier
            .padding(0.dp)

    )

}

@Composable
fun EasyImage() {
    Image(
        painter = painterResource(id = R.drawable.meliora),
        contentDescription = null,
        modifier = Modifier
            .size(40.dp)
            .padding(3.dp)
            .clip(RoundedCornerShape(3.dp))
    )

}

@Composable
fun EasyRow() {

}

@Composable
fun EasyColumn() {

}

@Composable
fun EasyBoxAndText() {
    Box(
        modifier = Modifier
            .size(10.dp)
            .background(PrimaryColor, shape = RoundedCornerShape(2.dp))
            .padding(top = 10.dp)
    )
    CustomText(text = "Hello there")

}

@Composable
fun EasyIconButton() {
    IconButton(
        onClick = { /*TODO*/ },
    ) {
        Icon(
            painter = painterResource(id = R.drawable.filter_search),
            contentDescription = "Search",
            tint = Color.Black,
            modifier = Modifier.size(30.dp)
        )
    }
}

/**
 *
 */


