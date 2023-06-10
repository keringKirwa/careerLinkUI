package com.kenya.internlink.screens

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kenya.internlink.R
import com.kenya.internlink.helpers.Destinations
import com.kenya.internlink.helpers.Navigation
import com.kenya.internlink.ui.theme.PrimaryColor
import com.kenya.internlink.ui.theme.customRoundedShape
import com.kenya.internlink.view_models.AuthViewModel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Preview(showBackground = true)
@Composable
fun LoginScreen() {

    var email by remember {
        mutableStateOf("kelvinKering")

    }
    var password by remember {
        mutableStateOf("@077Pqc7rs")
    }
    val scope = rememberCoroutineScope()

    val viewModel: AuthViewModel = viewModel()


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PrimaryColor),

        ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp), contentAlignment = Alignment.Center

        ) {
            Column(
                modifier = Modifier.padding(10.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "InternLink",
                    fontSize = 30.sp,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

            }
        }

        Card(
            modifier = Modifier
                .weight(1f)
                .padding(top = 10.dp, bottom = 0.dp)
                .fillMaxWidth()
                .clip(
                    shape = RoundedCornerShape(
                        topStart = 20.dp, topEnd = 20.dp, bottomStart = 0.dp, bottomEnd = 0.dp
                    )
                )

        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = "Welcome Back !",
                    fontSize = 22.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.height(30.dp))

                EmailTextField()
                Spacer(modifier = Modifier.height(16.dp))
                PasswordTextField()
                Spacer(modifier = Modifier.height(16.dp))
                LoginButton(email, password, scope, viewModel)
                Image(
                    painter = painterResource(id = R.drawable.careers_inside),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                        .padding(bottom = 15.dp)
                        .clip(RoundedCornerShape(16.dp))
                )

            }
        }

    }

}

@Composable
fun LoginButton(email: String, password: String, scope: CoroutineScope, viewModel: AuthViewModel) {
    val navController = Navigation.navControllerLocal.current
    Button(
        onClick = {
            scope.launch {
                navController.navigate(Destinations.LoginScreenRoute.routeName)
                viewModel.loginUser(email, password, navController)
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(top = 20.dp),
        shape = customRoundedShape,
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White, containerColor = PrimaryColor
        ),
        contentPadding = PaddingValues(vertical = 14.dp)
    ) {
        Text(text = "Login", fontFamily = FontFamily.Monospace)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailTextField() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()

    }

    TextField(value = text,
        singleLine = true,
        onValueChange = { text = it },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = Color.Black,
            focusedIndicatorColor = PrimaryColor,
            containerColor = Color.White
        ),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Email, contentDescription = "Your Email Address"
            )
        },
        label = { Text(text = "Email Address") },
        placeholder = { Text(text = "e.g johndoe@gmail.com") },
        modifier = Modifier
            .focusRequester(focusRequester)
            .onFocusChanged { focusState ->
                if (focusState.isFocused) {
                    focusRequester.requestFocus()
                }
            })
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(
) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(

        value = text,
        singleLine = true,
        onValueChange = {
            text = it
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text
        ),
        colors = TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = PrimaryColor,
            containerColor = Color.White
        ),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.AccountBox, contentDescription = "Your Email Address"
            )
        },
        label = { Text(text = "Your Password") },
        placeholder = { Text(text = "e.g John123@2023") },
    )

}
