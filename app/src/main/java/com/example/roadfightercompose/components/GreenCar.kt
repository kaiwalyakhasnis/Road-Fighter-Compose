package com.example.roadfightercompose.components

import androidx.compose.animation.core.animateFloat
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.roadfightercompose.R

@Composable
fun GreenCar(
    animation: Float,
    height: Dp,
    storeDispatcher: StoreDispatcher
) {
    val carPainter: Painter = painterResource(id = R.drawable.yellow_car)
    val carWidth: Dp = height * 0.5f
    val carOffset: Dp = height * 0.25f

    Box(
        modifier = Modifier
            .offset(y = carOffset)
            .rotate(animation * 360f)
    ) {
        Image(
            painter = carPainter,
            contentDescription = null,
            modifier = Modifier
                .height(carWidth)
                .width(carWidth)
        )
    }
}
