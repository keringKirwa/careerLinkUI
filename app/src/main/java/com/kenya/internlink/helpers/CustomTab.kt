package com.kenya.internlink.helpers

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.kenya.internlink.ui.theme.SealColor
import com.kenya.internlink.ui.theme.customRoundedShape

@Composable
fun CustomTab(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    Box(
        modifier = modifier
            .clickable(onClick = onClick, )
            .clip(customRoundedShape)
            .fillMaxWidth()
            .background(
                if (selected) {
                   SealColor
                } else {
                    Color.Transparent
                }
            )
    ) {
        content()
    }
}
