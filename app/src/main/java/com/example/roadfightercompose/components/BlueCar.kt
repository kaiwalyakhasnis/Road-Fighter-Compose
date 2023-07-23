package com.example.roadfightercompose.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.boundsInRoot
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.roadfighter.R
import com.example.roadfightercompose.store.StoreDispatcher
import com.example.roadfightercompose.store.reducer.BlueCarActions

@Composable
fun BlueCar(
    animation: Float,
    storeDispatcher: StoreDispatcher,
    height: Dp
) {
    val currentPosY = height * animation
    val blueCarPositionRange = 120..250
    val (blueCarOffset, setBlueCarOffset) = remember {
        mutableStateOf((blueCarPositionRange).random())
    }
    if ((0.000f..0.020f).contains(animation)) {
        setBlueCarOffset((blueCarPositionRange).random())
    }
    val offsetAnimation: Dp by animateDpAsState(
        blueCarOffset.dp
    )
    Image(
        painter = painterResource(R.drawable.blue_car),
        contentDescription = null,
        modifier = Modifier
            .absoluteOffset(
                x = offsetAnimation,
                y = currentPosY
            )
            .onGloballyPositioned { layoutCoordinates ->
                storeDispatcher.dispatch(
                    BlueCarActions.UpdateBounds(layoutCoordinates.boundsInRoot())
                )
            },
        contentScale = ContentScale.Fit
    )
}