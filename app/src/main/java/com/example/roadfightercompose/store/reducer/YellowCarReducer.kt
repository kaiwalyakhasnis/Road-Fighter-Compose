package com.example.roadfightercompose.store.reducer

import androidx.compose.ui.geometry.Rect
import com.example.roadfightercompose.store.state.YellowCarState
import org.reduxkotlin.Action
import org.reduxkotlin.reducerFor

sealed class YellowCarActions : Action {
    data class UpdateBounds(
        val rect: Rect
    ) : YellowCarActions()
}

val yellowCarReducer = reducerFor<YellowCarActions> { state, action ->
    when (action) {
        is YellowCarActions.UpdateBounds -> {
            val yellowCarState = state.yellowCarState.copy(bounds = action.rect)
            state.copy(yellowCarState = yellowCarState)
        }
    }
}