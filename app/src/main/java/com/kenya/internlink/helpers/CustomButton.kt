package com.kenya.internlink.helpers

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.kenya.internlink.ui.theme.PrimaryColor
import com.kenya.internlink.ui.theme.customRoundedShape
import com.kenya.internlink.view_models.AuthViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun CustomButton(text: String, action: ()->Unit?) {
    val navController = Navigation.navControllerLocal.current
    Button(
        onClick = {
            print("function called")
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(top = 20.dp),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White, containerColor = PrimaryColor
        ),
        contentPadding = PaddingValues(vertical = 14.dp)
    ) {
        Text(text = text, fontFamily = FontFamily.Monospace)
    }
}