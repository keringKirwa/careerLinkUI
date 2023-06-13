package com.kenya.internlink.screens.one_oppotunity

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.kenya.internlink.R
import com.kenya.internlink.helpers.CustomButton
import com.kenya.internlink.helpers.Destinations
import com.kenya.internlink.helpers.JobDescription
import com.kenya.internlink.ui.theme.PoppinsFontFamily
import com.kenya.internlink.ui.theme.PrimaryColor
import com.kenya.internlink.ui.theme.SealColor
import com.kenya.internlink.ui.theme.SecondaryColor
import com.kenya.internlink.ui.theme.customRoundedShape

@Composable
@Preview(showBackground = true)
fun SingleOpportunityScreen(navController: NavController? = null) {
    Column(
        modifier = Modifier
            .fillMaxSize()

    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(PrimaryColor)
        ) {
            //first row (Icons Row )
            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()

            ) {

                IconButton(
                    onClick = {
                        navController?.let {
                            it.navigate(Destinations.LandingScreen.routeName)

                        }
                    },
                    modifier = Modifier.background(Color.Transparent),

                    ) {

                    Icon(
                        modifier = Modifier.size(30.dp),
                        imageVector = Icons.Default.ArrowBack,

                        contentDescription = null,
                        tint = SealColor
                    )

                }
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.background(Color.Transparent)
                ) {

                    Icon(
                        painter = painterResource(id = R.drawable.book_mark),
                        contentDescription = null,
                        tint = SecondaryColor
                    )

                }

            }
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.careers_inside),
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(RoundedCornerShape(3.dp)),

                    )
                Spacer(modifier = Modifier.padding(bottom = 10.dp))

                Text(
                    text = "Doctor(MO)",
                    fontSize = 28.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    color = Color.White, textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.padding(bottom = 10.dp))
                Text(
                    text = "Nairobi, Kenya.",
                    color = SecondaryColor,
                    fontSize = 10.sp,
                    fontFamily = FontFamily.SansSerif,

                    )
                Spacer(modifier = Modifier.padding(bottom = 5.dp))
                Text(
                    text = "Full Time . 24K/month",
                    color = SealColor,
                    fontSize = 16.sp,
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.Normal

                )
                Spacer(modifier = Modifier.height(30.dp))

            }
        }
        Tabs()

    }

}


@Composable
fun Tabs() {
    var tabIndex by remember { mutableStateOf(0) }
    val tabTitles = listOf("Description", "Company", "Benefits")
    Column {
        TabRow(
            selectedTabIndex = tabIndex,
            indicator = { tabPositions ->
                Box(
                    Modifier
                        .tabIndicatorOffset(tabPositions[tabIndex])
                        .height(2.dp)
                        .clip(customRoundedShape)
                        .fillMaxWidth()
                        .background(SecondaryColor)
                )
            }
        ) {
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    selected = tabIndex == index,
                    onClick = { tabIndex = index },
                    selectedContentColor = PrimaryColor,
                    unselectedContentColor = PrimaryColor.copy(alpha = .7f),
                    text = { Text(text = title) }
                )
            }
        }
        when (tabIndex) {
            0 -> Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {

                Spacer(modifier = Modifier.padding(vertical = 2.dp))



                LazyColumn(
                    Modifier
                        .fillMaxWidth(),
                    contentPadding = PaddingValues(horizontal = 3.dp),
                ) {
                    item {
                        CustomTitle(text = "About This Job.")

                    }
                    item {

                        Spacer(modifier = Modifier.padding(vertical = 3.dp))
                    }
                    item {
                        Text(
                            text = JobDescription.aboutThisJob,
                            fontSize = 12.sp,
                            fontFamily = FontFamily.Default,
                            color = SecondaryColor,
                            modifier = Modifier.padding(start = 15.dp)
                        )
                    }

                    item {
                        Spacer(modifier = Modifier.padding(vertical = 10.dp))
                    }
                    item {
                        CustomTitle(text = "Qualifications.")
                    }
                    repeat(JobDescription.qualifications.size) {
                        item {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(10.dp)
                                        .background(PrimaryColor, shape = RoundedCornerShape(2.dp))
                                        .padding(top = 10.dp)
                                )
                               CustomText(text = JobDescription.qualifications[it])

                            }

                        }
                    }
                    item {
                        Spacer(modifier = Modifier.padding(vertical = 10.dp))
                    }
                    item {
                        CustomTitle(text = "Job Responsibilities.")
                    }
                    repeat(JobDescription.roles.size) {
                        item {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(10.dp)
                                        .background(PrimaryColor, shape = CircleShape)
                                        .padding(top = 10.dp),
                                )
                                CustomText(text  = JobDescription.roles[it],)

                            }

                        }
                    }

                    item {
                        CustomButton(text = "Apply Now") {
                        }
                    }

                    item {
                        Spacer(modifier = Modifier.padding(vertical = 10.dp))
                    }

                }

            }

            1 -> Text("There content")
            2 -> Text("World content")
        }
    }
}


@Composable
fun CustomText(text : String) {
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
fun CustomTitle(text : String) {
    Text(
        text = text,
        fontSize = 20.sp,
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.ExtraBold,
        color = PrimaryColor
    )

}





