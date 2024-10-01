package com.example.firstdemoprojectcompose.background

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val yellow = Color(0xFFF3A024)
val black = Color(0xFF090909)
@Composable
fun GradientBackgroundColor(
    modifier: Modifier = Modifier,
    content:@Composable BoxScope.() ->Unit
) {
    Box(modifier = modifier.background(brush = Brush.linearGradient(listOf(yellow,black))))
    {
        content()
    }

}