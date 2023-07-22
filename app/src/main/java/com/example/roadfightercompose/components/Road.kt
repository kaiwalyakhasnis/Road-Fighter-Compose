package com.example.roadfightercompose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.boundsInRoot
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.roadfighter.R
import com.example.roadfightercompose.store.StoreDispatcher
import com.example.roadfightercompose.store.reducer.RoadActions
import com.example.roadfightercompose.store.type.RoadSectionType

@Composable
fun BusyRoad(
    height: Dp,
    width: Dp,
    storeDispatcher: StoreDispatcher,
    animation: Float
) {
    val roadSectionModifier = Modifier.size(width, height)
    val scrollState = rememberScrollState()
    val currentPosY = height * animation

    Row {
        Column(
            modifier = Modifier
                .roadSection(scrollState)
                .weight(weight = 1f, fill = false)
                .onGloballyPositioned { layoutCoordinates ->
                    storeDispatcher.dispatch(
                        RoadActions.UpdateLeftBounds(layoutCoordinates.boundsInRoot())
                    )
                }
        ) {
            RoadSection(
                type = RoadSectionType.Left,
                modifier = roadSectionModifier,
                currentPosY = currentPosY,
                height = height * 2
            )
        }

        Column(
            modifier = Modifier
                .roadSection(scrollState)
                .weight(weight = 2.5f, fill = true)
        ) {
            RoadSection(
                type = RoadSectionType.Center,
                modifier = roadSectionModifier,
                currentPosY = currentPosY,
                height = height * 2
            )
        }

        Column(
            modifier = Modifier
                .roadSection(scrollState)
                .weight(weight = 0.5f, fill = true)
                .onGloballyPositioned { layoutCoordinates ->
                    storeDispatcher.dispatch(
                        RoadActions.UpdateRightBounds(layoutCoordinates.boundsInRoot())
                    )
                }
        ) {
            RoadSection(
                type = RoadSectionType.Right,
                modifier = roadSectionModifier,
                currentPosY = currentPosY,
                height = height * 2
            )
        }
    }
}

@Composable
fun RoadSection(
    type: RoadSectionType,
    modifier: Modifier,
    currentPosY: Dp,
    height: Dp
) {
    val image = painterResource(
        when (type) {
            RoadSectionType.Left -> R.drawable.road_left
            RoadSectionType.Right -> R.drawable.road_right
            RoadSectionType.Center -> R.drawable.road_center
        }
    )

    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier.offset(y = currentPosY),
        contentScale = ContentScale.FillBounds
    )
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier.offset(y = currentPosY - height + 2.dp),
        contentScale = ContentScale.FillBounds
    )
}

private fun Modifier.roadSection(
    scrollState: ScrollState
): Modifier = this
    .then(
        verticalScroll(scrollState)
    )
    .then(
        // absorb all vertical scrolls
        pointerInput(Unit) {
            detectVerticalDragGestures { change, _ ->
                change.consume()
            }
        }
    )