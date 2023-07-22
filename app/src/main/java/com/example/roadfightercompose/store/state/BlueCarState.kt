package com.example.roadfightercompose.store.state

import androidx.compose.ui.geometry.Rect
import com.example.roadfightercompose.components.BlueCarPositionState
import com.example.roadfightercompose.store.type.ReduxState

data class BlueCarState(
    val bounds: Rect = Rect.Zero
) : ReduxState {
    fun isCollidingWith(rect: Rect): Boolean {
        return bounds.overlaps(rect)
    }

    fun hasPassedPlayerCar(
        blueCarPosState: BlueCarPositionState,
        playerCarTop: Float
    ): Boolean {
        return !blueCarPosState.hasCounted && bounds.top >= playerCarTop
    }
}