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
        fontSize = 11.sp,
        letterSpacing = 0.3.sp,
        fontFamily = PoppinsFontFamily,
        fontWeight = FontWeight.ExtraLight,
        color = Color.Black.copy(.7f),
        modifier = Modifier
            .padding(start = 10.dp, top = 0.dp)

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
 * SuggestedJob(
companyImage = when (index) {
0 -> painterResource(id = R.drawable.appleicon)
1 -> painterResource(id = R.drawable.meliora)
2 -> painterResource(id = R.drawable.safaricom)
3 -> painterResource(id = R.drawable.meliora)
4 -> painterResource(id = R.drawable.eclectics)
else -> {
painterResource(id = R.drawable.meliora)
}
},
companyName =
when (index) {
0 -> "Apple"
1 -> "Meliora Technologies."
2 -> "Safaricon/M-pesa"
3 -> "Meliora"
4 -> "Eclectics Ltd."
else -> {
"InternLink"
}
}
)
 */

