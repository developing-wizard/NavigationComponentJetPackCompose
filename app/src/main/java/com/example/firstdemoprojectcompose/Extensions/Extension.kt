package com.example.firstdemoprojectcompose.Extensions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun isSmallHeight(): Boolean {
    val conf = LocalConfiguration.current
    return conf.screenHeightDp <= 786
}

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    label: String,
    keyboardActions: KeyboardActions,
    keyboardOptions: KeyboardOptions,
    readable: Boolean = false,
    height: Dp = 40.dp
) {
    var text by remember { mutableStateOf("") } // State to hold the text input

    Column(modifier = modifier) {
        Text(text = label, color = Color.White)

        Spacer(modifier = Modifier.height(10.dp))
        BasicTextField(
            value = text, // Link the text state to the value parameter
            onValueChange = { newText -> text = newText }, // Update the state on text change
            keyboardActions = keyboardActions,
            keyboardOptions = keyboardOptions,
            readOnly = readable,
            decorationBox = { innerTextField ->
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .height(height)
                        .background(Color.White)
                        .padding(start = 15.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    innerTextField() // Invoke the inner text field composable
                }
            }
        )
    }
}
