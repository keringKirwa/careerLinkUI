package com.kenya.internlink.screens.searching_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.kenya.internlink.R
import com.kenya.internlink.helpers.Destinations
import com.kenya.internlink.helpers.JobDescription
import com.kenya.internlink.ui.theme.PoppinsFontFamily
import com.kenya.internlink.ui.theme.PrimaryColor
import com.kenya.internlink.ui.theme.SealColor
import com.kenya.internlink.ui.theme.SecondaryColor
import com.kenya.internlink.ui.theme.customRoundedShape


@Composable
@Preview(showBackground = true)
fun SearchScreen(navController: NavController? = null) {
    var tabIndex by remember { mutableStateOf(0) }

    val bottomNavigationItems = listOf(
        SearchScreenIcons.All,
        SearchScreenIcons.Applied,
        SearchScreenIcons.Saved
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White), verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.padding(top = 5.dp))
            SearchRow(navController)
            Spacer(modifier = Modifier.padding(5.dp))
            IconAndFilterComponents(navController)
            Spacer(modifier = Modifier.padding(vertical = 5.dp))
            LazyColumn(
                Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                item {
                    Row(
                        Modifier
                            .padding(10.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        SearchCustomTitle(text = "Top Companies")
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.more_horiz_icon),
                                contentDescription = null,
                                tint = PrimaryColor,
                                modifier = Modifier.size(40.dp)

                            )
                        }
                    }
                }
                item {
                    //TODO: TOP COMPANIES

                    TopCompaniesLzyRow()
                }
                item { Spacer(modifier = Modifier.padding(5.dp)) }
                item {
                    Row(
                        Modifier
                            .padding(10.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        SearchCustomTitle(text = "Suggested Jobs")
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.more_horiz_icon),
                                contentDescription = null,
                                tint = PrimaryColor,
                                modifier = Modifier.size(40.dp)

                            )
                        }
                    }
                }
                item { Spacer(modifier = Modifier.padding(5.dp)) }
                repeat(5) {
                    item {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 20.dp),
                            elevation = CardDefaults.cardElevation((1).dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()

                            ) {
                                SuggestedJob(
                                    companyImage = when (it) {
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
                                    when (it) {
                                        0 -> "Apple"
                                        1 -> "Meliora Technologies."
                                        2 -> "Safaricon/M-pesa"
                                        3 -> "Meliora"
                                        4 -> "Eclectics Ltd."
                                        else -> {
                                            "InternLink"
                                        }
                                    },
                                    jobTitle =
                                    when (it) {
                                        0 -> "Software Engineer"
                                        1 -> "Medical Officer"
                                        2 -> "Mechanical Engineer"
                                        3 -> "Nursing"
                                        4 -> "Machine Learning"
                                        else -> {
                                            "Data Analyst"
                                        }
                                    }
                                )


                            }
                        }


                    }
                    item { Spacer(modifier = Modifier.padding(vertical = 10.dp)) }
                }
            }
        }

        TabRow(
            modifier = Modifier
                .fillMaxWidth(),
            selectedTabIndex = tabIndex,
            indicator = { tabPositions ->
                Box(
                    Modifier
                        .graphicsLayer {
                            // Adjust the vertical position of the indicator
                        }
                        .tabIndicatorOffset(tabPositions[tabIndex])
                        .height(2.dp)
                        .clip(customRoundedShape)
                        .fillMaxWidth()
                        .background(SecondaryColor)
                )
            }
        ) {
            bottomNavigationItems.forEachIndexed { index, item ->
                Tab(
                    selected = tabIndex == index,
                    onClick = { tabIndex = index },
                    selectedContentColor = PrimaryColor,
                    unselectedContentColor = PrimaryColor.copy(alpha = 0.7f),
                    modifier = Modifier.background(Color.White)
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(id = item.iconId), // Replace with your icon
                            contentDescription = null, // Set the description if needed
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = item.title,
                            fontSize = 13.sp,
                            letterSpacing = 0.3.sp,
                            fontFamily = PoppinsFontFamily,
                            fontWeight = FontWeight.ExtraLight,
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun SearchRow(navController: NavController?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .padding(horizontal = 12.dp, vertical = 5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {

        IconButton(
            onClick = {
                navController?.navigate(Destinations.HomeScreen.routeName)
            },
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Search",
                tint = Color.Black,
                modifier = Modifier.size(30.dp)
            )
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .height(45.dp), contentAlignment = Alignment.Center
        ) {
            CustomSearchFiled()
        }

        IconButton(onClick = {
            navController?.navigate(Destinations.SingleProductScreen.routeName)
        }) {
            Icon(
                imageVector = Icons.Outlined.Search,
                contentDescription = "Settings",
                tint = Color.Black,
                modifier = Modifier.size(34.dp)
            )
        }
    }

}

@Composable
fun IconAndFilterComponents(navController: NavController?) {
    Row(
        Modifier
            .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically

    ) {
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

        FilterItems()
    }


}

@Composable
fun FilterItems() {
    var selectedItemIndex by remember { mutableStateOf(0) }

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(7.dp)
    ) {
        itemsIndexed(JobDescription.industries) { index, item ->
            Box(
                modifier = Modifier
                    .height(IntrinsicSize.Min) // Adjust the height based on content
                    .background(
                        if (index == selectedItemIndex) PrimaryColor else SealColor,
                        shape = RoundedCornerShape(5.dp)
                    )
                    .clickable {
                        selectedItemIndex = index
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = item,
                    modifier = Modifier
                        .padding(horizontal = 20.dp, vertical = 10.dp)
                        .fillMaxSize()
                        .align(Alignment.Center),
                    color = if (index == selectedItemIndex) SecondaryColor else PrimaryColor,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}


@Composable
fun SearchCustomTitle(text: String) {
    Text(
        text = text,
        fontSize = 20.sp,
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.ExtraBold,
        color = PrimaryColor
    )

}


@Composable
fun TopCompaniesLzyRow() {
    LazyRow(
        Modifier
            .fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        repeat(5) { index ->
            item {
                CompanyAndAttachment(
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
                    companyName = "Meliora Technologies",
                    numberOfJobVacancies = "45 Job Vacancies",
                    salary = "salary : ".plus("100k-200/month "),
                    onlineOrRemote = "Online/Remote"
                )
            }
        }

    }

}

@Composable
fun CompanyAndAttachment(
    companyImage: Painter,
    companyName: String,
    numberOfJobVacancies: String,
    salary: String,
    onlineOrRemote: String

) {
    Column(
        modifier = Modifier
            .width(250.dp)
            .background(
                SealColor,
                shape = RoundedCornerShape(
                    4.dp
                )
            )
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 5.dp),

            ) {
            Box(
                modifier = Modifier
                    .background(Color.White, shape = customRoundedShape)
                    .size(45.dp), contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = companyImage,
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .padding(3.dp)
                        .clip(RoundedCornerShape(3.dp))
                )
            }

            Spacer(modifier = Modifier.padding(5.dp))
            Column(
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.width(160.dp)
            ) {

                Text(
                    text = companyName,
                    fontSize = 18.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.Black
                )
                Text(
                    text = numberOfJobVacancies,
                    fontSize = 11.sp,
                    letterSpacing = 0.3.sp,
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.ExtraLight,
                    color = Color.Black.copy(.7f),
                )
            }

        }
        CustomDotAndText(salary)
        CustomDotAndText(onlineOrRemote)
        Spacer(modifier = Modifier.height(10.dp))
        SeeMoreSection()

    }

}

@Composable
fun SeeMoreSection() {
    Box(
        modifier = Modifier
            .background(
                PrimaryColor.copy(alpha = .05f),
                shape = RoundedCornerShape(bottomEnd = 10.dp, bottomStart = 10.dp)
            )
            .fillMaxWidth()
            .height(40.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "visit Jobs",
                fontSize = 13.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                color = PrimaryColor,
                modifier = Modifier
                    .padding(0.dp)
            )
            Text(
                text = "Our InfoLine",
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


@Composable
fun CustomDotAndText(text: String) {
    Row(
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 2.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(7.dp)
                .background(PrimaryColor, shape = CircleShape)

        )
        Spacer(modifier = Modifier.padding(horizontal = 5.dp))
        Text(
            text = text,
            fontSize = 11.sp,
            textAlign = TextAlign.Center,
            letterSpacing = 0.3.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Normal,
            color = Color.Black.copy(.7f),

            )


    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSearchFiled() {
    val enteredText = remember { mutableStateOf(TextFieldValue("")) }

    BoxWithConstraints(modifier = Modifier.clipToBounds()) {
        TextField(
            value = enteredText.value,
            shape = CircleShape,
            onValueChange = { enteredText.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeight(maxHeight + 10.dp),
            textStyle = LocalTextStyle.current.copy(
                fontSize = 16.sp,
                fontFamily = FontFamily.SansSerif
            ),
            singleLine = true,
            placeholder = {
                Text(
                    text = "Search opportunities ...",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 14.sp
                )
            },
            trailingIcon = {
                if (enteredText.value.text.isNotEmpty()) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        tint = PrimaryColor,
                        contentDescription = "Clear",
                        modifier = Modifier
                            .clickable {
                                enteredText.value = TextFieldValue("")
                            }
                            .background(Color.White, shape = CircleShape)
                    )
                }
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = SealColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedLabelColor = PrimaryColor,
            ),
        )
    }
}
