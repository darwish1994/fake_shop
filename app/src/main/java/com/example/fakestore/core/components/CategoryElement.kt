package com.example.fakestore.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fakestore.R


@Composable
fun CategoryUi(modifier: Modifier = Modifier, name: String, onclick: (String) -> Unit) {

    Box(
        contentAlignment = Center,
        modifier = modifier
            .fillMaxSize()
            .background(
                color = colorResource(id = R.color.purple_500),
                shape = RoundedCornerShape(15.dp)
            )
            .clickable {
                onclick.invoke(name)
            }
    ) {
        Text(
            text = name,
            fontSize = 16.sp,
            color = Color.White,
            modifier = Modifier.padding(16.dp),
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center

        )
    }

}