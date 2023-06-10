package com.kenya.internlink.screens

import android.annotation.SuppressLint
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.kenya.internlink.ui.theme.PrimaryColor
import com.kenya.internlink.ui.theme.Purple80
import kotlinx.coroutines.flow.callbackFlow

@SuppressLint("MutableCollectionMutableState")
@Composable
@Preview
@Preview(showBackground = true)
fun DialPadLoginScreen() {

    var password by remember { mutableStateOf("") }


    val dialPadDigits = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9),
    )

    fun onDelete() {
        if (password.isNotEmpty()) {
            password = password.dropLast(1)
        }
    }

    val onNumberClick: (String) -> Unit = { number ->
        run {
            if (password.length < 4) {
                password = password.plus(number)
            }
        }

    }


    Column(
        modifier = Modifier
            .fillMaxSize().background(PrimaryColor),
        verticalArrangement = Arrangement.Center
    ) {
        //  4-digit password Box
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),

            ) {
            repeat(4) { digitIndex ->
                Box(
                    modifier = Modifier
                        .padding(10.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(5.dp))
                        .height(70.dp)
                        .width(75.dp)
                        .weight(1f)
                        .animateContentSize(),

                ) {
                    val n =
                        if (digitIndex < password.length && password.isNotEmpty()) password[digitIndex]
                        else null

                    if (n != null) {
                        Text(
                            text = n.toString(),
                            fontSize = 36.sp,
                            color = Color.White,
                            fontFamily = FontFamily.Monospace,
                            fontStyle = FontStyle.Italic,
                            fontWeight = FontWeight.Bold,

                            )
                    } else {
                        Box(
                            modifier = Modifier
                                .height(10.dp)
                                .width(50.dp)
                                .clip(RoundedCornerShape(3.dp))
                                .background(color = Color.Cyan),

                        )
                    }
                }

            }


        }

        // Second box containing numbers 1-9
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp),
            horizontalAlignment = CenterHorizontally
        ) {
            for (row in dialPadDigits) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    for (digit in row) {
                        DialButton(
                            modifier = Modifier.weight(1f),
                            number = digit.toString(),
                            onClick = { onNumberClick.invoke(digit.toString()) }
                        )

                    }
                }

            }

            //Box containing number 0 and delete button

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
            ) {
                Spacer(
                    modifier = Modifier
                        .size(70.dp)
                        .weight(1f)
                )

                DialButton(
                    number = "0",
                    onClick = {
                        onNumberClick.invoke("0")
                    },
                    modifier = Modifier.weight(1f)
                )
                DialButton(
                    number = "X",
                    onClick = { onDelete() },
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }


}




@Composable
fun DialButton(
    number: String,

    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = Color.Black
        ),
        onClick = { onClick() },
        modifier = modifier
            .height(80.dp),
        shape = RoundedCornerShape(3.dp),

        ) {
        Text(
            text = number,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif
        )
    }
}

