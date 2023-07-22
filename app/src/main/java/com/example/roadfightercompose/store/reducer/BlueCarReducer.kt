package com.example.roadfightercompose.store.reducer

import androidx.compose.ui.geometry.Rect
import mozilla.components.lib.state.Action

sealed class BlueCarActions : Action {
    data class UpdateBounds(
        val rect: Rect
    ) : BlueCarActions()
}

val blueCarReducer = reducerFor<BlueCarActions> { state, action ->
    when (action) {
        is BlueCarActions.UpdateBounds -> {
            val blueCarState = state.blueCarState.copy(bounds = action.rect)
            state.copy(blueCarState = blueCarState)
        }
    }
}