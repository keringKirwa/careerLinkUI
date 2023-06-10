package com.kenya.internlink.screens.landing_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kenya.internlink.ui.theme.PrimaryColor
import com.kenya.internlink.ui.theme.SealColor
import com.kenya.internlink.ui.theme.SecondaryColor


@Composable
fun FeaturedItem(
    companyName: String,
    jobTitle: String,
    workingTime: String,
    salaryAmount: String,
    countyName: String,
    imagePainter: Painter
) {
    Card(
        modifier = Modifier
            .width(250.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(PrimaryColor)
                ,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            //first
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

            ) {
                Column() {
                    Image(
                        painter = imagePainter,
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                            .clip(
                                RoundedCornerShape(4.dp)
                            )
                    )
                    Text(text = companyName, fontFamily = FontFamily.SansSerif, color = SecondaryColor)

                }
                Column(
                    modifier = Modifier.background(Color.Transparent),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.MailOutline,
                        contentDescription = null,
                        tint = SecondaryColor
                    )
                    Text(text = "Book Mark", fontSize = 10.sp, color = Color.White)


                }


            }

            //second
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
            ) {
                Text(
                    text = jobTitle,
                    fontSize = 20.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White
                )

            }
            //third
            Row(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = workingTime,
                    fontSize = 10.sp,
                    fontFamily = FontFamily.SansSerif,
                    color = Color.LightGray

                )
                Text(
                    text = salaryAmount,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )


            }

        }


    }
}