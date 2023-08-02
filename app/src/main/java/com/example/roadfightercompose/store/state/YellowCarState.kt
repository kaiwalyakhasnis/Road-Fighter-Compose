package com.example.roadfightercompose.store.state

import androidx.compose.ui.geometry.Rect
import org.reduxkotlin.ReduxState

data class YellowCarState(
    val bounds: Rect = Rect.Zero
) : ReduxState {
    fun isCollidingWith(rect: Rect): Boolean {
        return bounds.overlaps(rect)
    }
}