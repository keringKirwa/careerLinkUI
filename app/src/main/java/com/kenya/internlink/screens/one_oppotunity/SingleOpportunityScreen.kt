package com.kenya.internlink.screens.one_oppotunity

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kenya.internlink.R
import com.kenya.internlink.ui.theme.PrimaryColor
import com.kenya.internlink.ui.theme.SecondaryColor

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.kenya.internlink.ui.theme.customRoundedShape

@Composable
@Preview(showBackground = true)
fun SingleOpportunityScreen() {
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
                    onClick = { /*todo : */ },
                    modifier = Modifier.background(Color.Transparent),

                    ) {

                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        tint = Color.White
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
                        .size(70.dp)
                        .clip(CircleShape),

                    )
                Spacer(modifier = Modifier.padding(bottom = 10.dp))

                Text(
                    text = "Senior UI/UX Designer",
                    fontSize = 22.sp,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.padding(bottom = 10.dp))
                Text(
                    text = "Nairobi, Kenya.",
                    color = SecondaryColor,
                    fontSize = 10.sp,
                    fontFamily = FontFamily.SansSerif
                )
                Spacer(modifier = Modifier.padding(bottom = 5.dp))
                Text(
                    text = "Full Time . 24K/month",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif
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
    val tabTitles = listOf("Hello", "There", "World")
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
            0 -> Text("Hello content")
            1 -> Text("There content")
            2 -> Text("World content")
        }
    }
}






