package com.kenya.internlink.screens.landing_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
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
fun RecommendedOpportunity(
    jobTitle: String,
    isIntern: Boolean,
    workingTime: String,
    companyName: String,
    salaryAmount: String,
    countyName: String,
    imagePainter: Painter
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(SealColor, shape = RoundedCornerShape(10.dp))
        ,
        horizontalAlignment = Alignment.Start

    ) {

        val jobDescription = if (isIntern) {
            jobTitle.plus("(Internship program)")

        } else {
            jobTitle.plus("(Attachment program)")
        }
        Spacer(modifier = Modifier.padding(vertical = 5.dp))

        Text(
            text = jobDescription,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontSize = 10.sp,
            color = Color.Black,
            modifier = Modifier.padding(start = 20.dp, end = 10.dp)
        )



        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(SealColor, shape = RoundedCornerShape(10.dp))
                .height(80.dp).padding(start = 20.dp, end = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = imagePainter, contentDescription = null, modifier = Modifier
                    .size(50.dp)
                    .clip(
                        RoundedCornerShape(6.dp)
                    )
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = companyName,
                    fontSize = 17.sp,

                    color = PrimaryColor,
                    fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Bold
                )
                Text(
                    text = countyName.plus(" . ").plus(workingTime),
                    fontSize = 10.sp,
                    color = Color.Black

                )

            }
            Column(
                modifier = Modifier.background(Color.Transparent),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Default.MailOutline,
                    contentDescription = null,
                    tint = SecondaryColor
                )
                Text(text = salaryAmount, fontSize = 10.sp, color = Color.LightGray)

            }


        }

    }


}