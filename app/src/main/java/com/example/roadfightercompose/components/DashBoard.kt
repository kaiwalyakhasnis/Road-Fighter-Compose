package com.example.roadfightercompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DashBoard(
    score: Int,
    level: Int = 1,
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .background(color = Color.Black)
            .padding(horizontal = 20.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                text = "Score",
                color = Color.White,
                fontSize = 20.sp,
            )
        }

        Row{
            Text(
                text = "$score",
                color = Color.White,
                fontSize = 20.sp
            )
        }

        Row(
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                text = "Level",
                color = Color.White,
                fontSize = 20.sp,
            )
        }

        Row{
            Text(
                text = "$level",
                color = Color.White,
                fontSize = 20.sp
            )
        }
    }
}