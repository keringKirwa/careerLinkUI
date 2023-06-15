package com.kenya.internlink.screens.blogs_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.navigation.NavController
import com.kenya.internlink.R
import com.kenya.internlink.helpers.Destinations
import com.kenya.internlink.ui.theme.PoppinsFontFamily
import com.kenya.internlink.ui.theme.PrimaryColor
import com.kenya.internlink.ui.theme.SealColor
import com.kenya.internlink.ui.theme.SecondaryColor
import com.kenya.internlink.ui.theme.customRoundedShape

@Composable
@Preview(showBackground = true)
fun BlogsScreen(navController: NavController? = null) {
    Column(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    SealColor,
                    shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)
                )
                .padding(bottom = 10.dp)
        ) {
            TopBarBlogScreen(navController = navController)
            Row(
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 5.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center

            ) {
                Box(
                    modifier = Modifier
                        .background(Color.White, shape = customRoundedShape)
                        .size(45.dp), contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.safaricom),
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
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Text(
                        text = "Eclectics International Ltd.",
                        fontSize = 20.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Text(
                        text = "@eclecticsInfoLine",
                        fontSize = 11.sp,
                        letterSpacing = 0.3.sp,
                        fontFamily = PoppinsFontFamily,
                        fontWeight = FontWeight.ExtraLight,
                        color = PrimaryColor,
                    )
                }

            }
            Spacer(modifier = Modifier.height(5.dp))
            Row(
                modifier = Modifier
                    .padding(horizontal = 30.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Row(
                    modifier = Modifier
                        .height(40.dp)
                        .border(1.dp, PrimaryColor, shape = CircleShape)
                        .width(120.dp)
                        .background(Color.White, shape = CircleShape)
                        .clip(CircleShape)
                        .clickable { print("Clicked") },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.follow_icon),
                        contentDescription = null,
                        tint = PrimaryColor,
                        modifier = Modifier.size(25.dp)
                    )
                    Text(
                        text = "Follow",
                        fontSize = 14.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        color = PrimaryColor
                    )
                }


                StackedImagesWithLikes()

            }

        }

    }


}


@Composable
fun StackedImagesWithLikes() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        // Stacked Images
        Spacer(modifier = Modifier.weight(1f))

        Box(
            modifier = Modifier.padding(end = 10.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.ceo_1),
                contentDescription = "Image 1",
                modifier = Modifier
                    .size(17.dp)
                    .clip(CircleShape)
                    .background(Color.White)
            )
            Image(
                painter = painterResource(R.drawable.kering_profile),
                contentDescription = "Image 2",
                modifier = Modifier
                    .size(22.dp)
                    .offset(x = 15.dp)
                    .clip(CircleShape)
                    .background(Color.White)
            )
            Image(
                painter = painterResource(R.drawable.ceo2),
                contentDescription = "Image 3",
                modifier = Modifier
                    .size(27.dp)
                    .offset(x = 30.dp)
                    .clip(CircleShape)
                    .background(Color.White)
            )
            Box(
                modifier = Modifier
                    .size(34.dp)
                    .offset(x = 50.dp)
                    .background(PrimaryColor, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "+23K",
                    color = SecondaryColor,
                    fontWeight = FontWeight.Bold,
                    fontSize = 9.sp
                )
            }
        }
        Spacer(modifier = Modifier.width(45.dp))

        Text(
            text = "Following",
            fontSize = 12.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            color = PrimaryColor
        )


    }
}


@Composable
fun TopBarBlogScreen(navController: NavController?) {
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

            Spacer(modifier = Modifier.padding(horizontal = 10.dp))
            Text(
                text = "Friday, 17 September.",
                fontSize = 10.sp,
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
                    imageVector = Icons.Outlined.Notifications,
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
