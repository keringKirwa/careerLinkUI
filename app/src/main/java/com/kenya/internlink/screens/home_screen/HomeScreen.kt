package com.kenya.internlink.screens.home_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.kenya.internlink.AppData
import com.kenya.internlink.R
import com.kenya.internlink.helpers.Destinations
import com.kenya.internlink.screens.landing_screen.DummySearchTextField
import com.kenya.internlink.screens.landing_screen.SearchRow
import com.kenya.internlink.screens.one_oppotunity.CustomText
import com.kenya.internlink.screens.one_oppotunity.CustomTitle
import com.kenya.internlink.ui.theme.PrimaryColor
import com.kenya.internlink.ui.theme.SealColor
import com.kenya.internlink.ui.theme.SecondaryColor

@Composable
@Preview(showBackground = true)
fun HomeScreen(navController: NavController? = null) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        HomeSearchRow(navController = navController)
        val annotatedText = buildAnnotatedString {
            append(" Good morning")
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold,
                    color = PrimaryColor,
                    fontSize = 15.sp
                )
            ) {
                append(" Kelvin Kering.")
            }
        }

        Text(
            text = annotatedText,
            fontSize = 12.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            color = Color.Gray,
            modifier = Modifier
                .padding(start = 0.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.padding(vertical = 15.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp)
        ) {
            Text(
                text = "Find Your Jobs.",
                fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.ExtraBold,
            )
        }
        Spacer(modifier = Modifier.padding(vertical = 15.dp))
        FindYourJobSection()

        Spacer(modifier = Modifier.padding(vertical = 20.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "What Do Our Students Say ? ",
                fontSize = 17.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.ExtraBold,
            )
        }
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        WhatOurStudentsSay()
    }

}


@Composable
fun HomeSearchRow(navController: NavController?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .padding(vertical = 5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .background(Color.Transparent)
                .padding(0.dp)
                .weight(1f),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = R.drawable.safaricom),
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
                    .padding(3.dp)
                    .clip(RoundedCornerShape(3.dp))
            )
            Spacer(modifier = Modifier.padding(horizontal = 3.dp))
            Text(
                text = "InternLink",
                fontSize = 14.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                color = PrimaryColor,
                modifier = Modifier
                    .padding(0.dp)
            )
        }
        Row(
            modifier = Modifier
                .background(Color.Transparent)
                .padding(end = 10.dp)
                .weight(1f),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Spacer(modifier = Modifier.weight(1f))
            IconButton(
                onClick = {
                    navController?.navigate(Destinations.SearchScreen.routeName)
                },
            ) {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = null,
                    tint = PrimaryColor,
                    modifier = Modifier.size(25.dp)
                )
            }
            Image(
                painter = painterResource(id = R.drawable.kering_profile),
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
                    .padding(3.dp)
                    .clip(shape = CircleShape)
            )

        }

    }

}

@Composable
fun FindYourJobSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(175.dp),
    ) {

        //First Column
        Card(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            elevation = CardDefaults.cardElevation((2).dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.all_jobs),
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier.size(40.dp)
                )
                Text(
                    text = "44.8k",
                    fontSize = 32.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    color = PrimaryColor,
                    modifier = Modifier
                        .padding(0.dp)
                )
                Spacer(modifier = Modifier.padding(vertical = 2.dp))

                Text(
                    text = "Job Opportunities",
                    fontSize = 13.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(0.dp)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(PrimaryColor.copy(alpha = .05f))
                        .height(40.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "See More",
                        fontSize = 13.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        color = PrimaryColor,
                        modifier = Modifier
                            .padding(0.dp)
                    )

                }
            }

        }


        //Second column

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
                .weight(1f)
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                elevation = CardDefaults.cardElevation((1).dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround

                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.part_time),
                            contentDescription = null,
                            tint = Color.Black,
                            modifier = Modifier.size(25.dp)
                        )
                        Column() {
                            Text(
                                text = "27.7k",
                                fontSize = 15.sp,
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.Bold,
                                color = PrimaryColor,
                                modifier = Modifier
                                    .padding(0.dp)
                            )
                            Text(
                                text = "Remote",
                                fontSize = 10.sp,
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.Bold,
                            )


                        }


                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(PrimaryColor.copy(alpha = .03f))
                            .height(32.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "See More",
                            fontSize = 13.sp,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold,
                            color = PrimaryColor,
                        )

                    }

                }
            }
            Spacer(modifier = Modifier.padding(5.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                elevation = CardDefaults.cardElevation((1).dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround

                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.part_time),
                            contentDescription = null,
                            tint = Color.Black,
                            modifier = Modifier.size(25.dp)
                        )
                        Column() {
                            Text(
                                text = "27.7k",
                                fontSize = 15.sp,
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.Bold,
                                color = PrimaryColor,
                                modifier = Modifier
                                    .padding(0.dp)
                            )
                            Text(
                                text = "Full Time",
                                fontSize = 10.sp,
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.Bold,
                            )


                        }


                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(PrimaryColor.copy(alpha = .03f))
                            .height(32.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "See More",
                            fontSize = 13.sp,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold,
                            color = PrimaryColor,
                        )

                    }

                }
            }


        }

    }

}

@Composable
fun WhatOurStudentsSay() {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        repeat(AppData.testimonials.size) {
            val item = AppData.testimonials[it]
            item {
                WhatStudentSay(item.name, item.role, item.companyName, item.content)

            }
        }

    }


}

@Composable
fun WhatStudentSay(
    name: String = "Kelvin Kering",
    role: String = "Engineer",
    companyName: String = "Amazon Ltd",
    content: String = "Hello there people"
) {
    val newRole = role.plus(" at ").plus(companyName)
    Column(
        modifier = Modifier
            .padding(horizontal = 5.dp)
            .width(300.dp)
            .background(
                SealColor,
                shape = RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp, topEnd = 10.dp)
            ),
    ) {
        Row(
            modifier = Modifier
                .padding(start = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.kering_profile),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.padding(start = 10.dp))
            Column(
                modifier = Modifier
            ) {
                Text(
                    text = name,
                    fontSize = 13.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.ExtraBold,
                    color = PrimaryColor
                )
                Text(
                    text = newRole,
                    fontSize = 20.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.ExtraBold,
                )
            }
        }
        Spacer(modifier = Modifier.padding(vertical = 5.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp)
        ) {
            CustomText(text = content)

        }

    }

}
