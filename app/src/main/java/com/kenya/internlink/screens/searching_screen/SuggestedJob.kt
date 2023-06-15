package com.kenya.internlink.screens.searching_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kenya.internlink.R
import com.kenya.internlink.screens.one_oppotunity.CustomText
import com.kenya.internlink.ui.theme.PoppinsFontFamily
import com.kenya.internlink.ui.theme.PrimaryColor
import com.kenya.internlink.ui.theme.SealColor
import com.kenya.internlink.ui.theme.SecondaryColor

@Composable
@Preview(showBackground = true)
fun SuggestedJob(
    companyImage: Painter = painterResource(id = R.drawable.appleicon),
    jobTitle: String = "Software Engineer",
    companyName: String = "Apple"
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color.Transparent, shape = RoundedCornerShape(7.dp)
            )
            .padding(horizontal = 5.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = companyImage,
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .padding(3.dp)
                    .background(SealColor, shape = RoundedCornerShape(10.dp))
                    .clip(RoundedCornerShape(3.dp))
            )
            Spacer(modifier = Modifier.padding(horizontal = 10.dp))
            Column(
                modifier = Modifier
                    .weight(1f),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = jobTitle,
                    fontSize = 14.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    color = PrimaryColor,

                    modifier = Modifier
                        .padding(start = 10.dp, top = 0.dp)
                )
                Spacer(modifier = Modifier.padding(vertical = 5.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = companyName,
                        fontSize = 12.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        color = PrimaryColor,
                        modifier = Modifier
                            .padding(start = 10.dp, top = 0.dp)
                    )
                    Text(
                        text = "Ksh. 150K/month",
                        fontSize = 9.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        color = SecondaryColor,
                        modifier = Modifier
                            .padding(start = 10.dp, top = 0.dp)
                    )
                }
            }

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.padding(0.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.location_icon),
                        contentDescription = "Search",
                        tint = Color.Black,
                        modifier = Modifier.size(20.dp)
                    )
                    Text(
                        text = "Nairobi",
                        fontSize = 11.sp,
                        letterSpacing = 0.3.sp,
                        fontFamily = PoppinsFontFamily,
                        fontWeight = FontWeight.ExtraLight,
                        color = Color.Black.copy(.6f),
                        modifier = Modifier
                            .padding(start = 5.dp, top = 0.dp)
                    )

                }
                Spacer(modifier = Modifier.padding(horizontal = 10.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .background(PrimaryColor, shape = CircleShape)
                            .padding(end = 5.dp)

                    )
                    Text(
                        text = "Internship(Remote)",
                        fontSize = 11.sp,
                        letterSpacing = 0.3.sp,
                        fontFamily = PoppinsFontFamily,
                        fontWeight = FontWeight.ExtraLight,
                        color = Color.Black.copy(.7f),
                        modifier = Modifier
                            .padding(start = 5.dp, top = 0.dp)
                    )
                }


            }
            Row(
                verticalAlignment = Alignment.CenterVertically

            ) {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(PrimaryColor, shape = CircleShape)

                )
                CustomText(text = "3d ago")

            }

        }
        Spacer(modifier = Modifier.height(10.dp))
        ActionsSection()


    }
}

@Composable
fun ActionsSection() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(SealColor),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        repeat(3) {
            Row(
                modifier = Modifier
                    .background(SealColor, shape = RoundedCornerShape(4.dp))
                    .weight(1f)
                    .height(40.dp)
                    .clickable { print("Clicked") },

                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(
                            id = when (it) {
                                0 -> R.drawable.like_icon
                                1 -> R.drawable.comments_icon
                                2 -> R.drawable.share_icon
                                else -> {
                                    R.drawable.like_icon
                                }
                            }
                        ),
                        contentDescription = "Search",
                        tint = Color.Black,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.padding(horizontal = 3.dp))
                    Text(
                        text = "Like",
                        fontSize = 10.sp,
                        fontFamily = FontFamily.SansSerif,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(0.dp)

                    )
                    
                }
            }
        }


    }
}
