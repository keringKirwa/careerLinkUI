package com.kenya.internlink.screens.searching_screen

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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Search
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kenya.internlink.R
import com.kenya.internlink.helpers.JobDescription
import com.kenya.internlink.screens.landing_screen.FeaturedItem
import com.kenya.internlink.ui.theme.PoppinsFontFamily
import com.kenya.internlink.ui.theme.PrimaryColor
import com.kenya.internlink.ui.theme.SealColor
import com.kenya.internlink.ui.theme.SecondaryColor
import com.kenya.internlink.ui.theme.customRoundedShape


@Composable
@Preview(showBackground = true)
fun SearchScreen() {
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
            Spacer(modifier = Modifier.padding(top = 10.dp))
            SearchRow()
            Spacer(modifier = Modifier.padding(top = 5.dp))
            SelectableRows()

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
fun SelectableRows() {
    Row(
        Modifier
            .fillMaxWidth()

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
                    .padding(horizontal = 5.dp)
                    .background(
                        if (index == selectedItemIndex) PrimaryColor else SealColor,
                        shape = customRoundedShape
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
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
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

        IconButton(
            onClick = { /*TODO*/ },
        ) {
            Icon(
                painter = painterResource(id = R.drawable.notifications_saerch),
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

        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Outlined.Search,
                contentDescription = "Settings",
                tint = Color.Black,
                modifier = Modifier.size(34.dp)
            )
        }
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
