package com.kenya.internlink.screens.landing_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kenya.internlink.R
import com.kenya.internlink.ui.theme.DividerColor
import com.kenya.internlink.ui.theme.PrimaryColor
import com.kenya.internlink.ui.theme.SecondaryColor
import com.kenya.internlink.ui.theme.customRoundedShape


@Preview(showBackground = true)
@Composable
fun LandingScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .safeContentPadding()
    ) {
        Box(
            modifier = Modifier
                .background(
                    PrimaryColor,
                    shape = RoundedCornerShape(bottomEnd = 50.dp, bottomStart = 50.dp)
                )
                .height(120.dp)
                .fillMaxWidth()
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent)

        ) {
            SearchRow()
            AccountInfoRow()
            Spacer(modifier = Modifier.height(25.dp))
            FeaturedOpportunities()
            Spacer(modifier = Modifier.height(25.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
            {
                RecommendedOpportunities()
            }


        }
    }
}

@Composable
fun SearchRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .padding(horizontal = 12.dp, vertical = 5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Box(modifier = Modifier.weight(1f)) {
            CustomTextField()
        }

        IconButton(
            onClick = { /*TODO*/ },
        ) {
            Icon(
                imageVector = Icons.Outlined.Settings,
                contentDescription = "Search",
                tint = Color.White,
                modifier = Modifier.size(30.dp)
            )
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Outlined.Notifications,
                contentDescription = "Settings",

                tint = Color.White,
                modifier = Modifier.size(34.dp)
            )
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
) {
    var text = remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        shape = RoundedCornerShape(5.dp),
        value = text.value,
        singleLine = true,
        maxLines = 1,
        onValueChange = {
            text.value = it
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text
        ),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search"
            )
        },
        label = { Text(text = "Search Opportunities ...", fontSize = 12.sp) },
        placeholder = {
            Text(
                text = "e.g internships ...",
                fontFamily = FontFamily.SansSerif,
                fontSize = 10.sp
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedLabelColor = PrimaryColor,

            ),

        )
}


@Composable
fun AccountInfoRow() {

    Spacer(modifier = Modifier.padding(5.dp))

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 14.dp)
            .height(70.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        shape = customRoundedShape

    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(horizontal = 2.dp)
                    .weight(1f)
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.ThumbUp,
                        tint = PrimaryColor,
                        contentDescription = "",
                    )

                }
                Column() {
                    Text(
                        text = "100k",
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Text(
                        text = "Likes",
                        color = Color.LightGray,
                        fontSize = 10.sp,
                        fontFamily = FontFamily.SansSerif
                    )

                }

            }
            VerticalDivider()
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                    .padding(end = 2.dp)
                    .weight(1f)
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "",
                        tint = PrimaryColor
                    )

                }
                Column() {
                    Text(
                        text = "20K",
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "profile Views",
                        lineHeight = 13.sp,
                        color = Color.LightGray,
                        fontSize = 9.sp,
                        fontFamily = FontFamily.SansSerif
                    )

                }
            }

            VerticalDivider()
            /**
             * Last item
             */
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                    .padding(horizontal = 2.dp)
                    .weight(1f)
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = "",
                        tint = PrimaryColor
                    )

                }
                Column() {
                    Text(
                        text = "100",
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Followers",
                        color = Color.LightGray,
                        fontSize = 10.sp,
                        fontFamily = FontFamily.SansSerif
                    )

                }
            }
        }

    }
}

@Composable
fun VerticalDivider() {
    Divider(
        color = DividerColor,
        modifier = Modifier
            .width(1.dp)
            .height(45.dp)
    )
}


@Composable
fun FeaturedOpportunities() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp), contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Most Rated Opportunities",
            color = PrimaryColor,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif
        )
    }

    LazyRow(
        Modifier
            .height(160.dp)
            .fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        repeat(5) {
            item {
                FeaturedItem(
                    imagePainter = painterResource(id = R.drawable.careers_inside),
                    companyName = "InternLink",
                    jobTitle = "Software Engineer",
                    workingTime = "full time . Nairobi",
                    salaryAmount = "$700",
                    countyName = "Nairobi"

                )
            }
        }

    }
}

@Composable
fun RecommendedOpportunities() {
    Column(modifier = Modifier.fillMaxSize()) {


        LazyColumn(
            Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Transparent)
                        .padding(bottom = 20.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Recommended For You",
                        color = PrimaryColor,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.ExtraBold,
                        fontFamily = FontFamily.SansSerif
                    )
                }
            }

            repeat(3) {
                item {
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 5.dp, vertical = 5.dp)
                            .fillMaxWidth()

                    ) {
                        RecommendedOpportunity(
                            jobTitle = "Software Engineer",
                            workingTime = "Full Time",
                            salaryAmount = "Ksh. 100,000/month",
                            countyName = "Kiambu",
                            isIntern = true,
                            companyName = "Safaricom Kenya",
                            imagePainter = painterResource(id = R.drawable.careers_inside)
                        )
                    }


                }
            }

        }
    }

}








