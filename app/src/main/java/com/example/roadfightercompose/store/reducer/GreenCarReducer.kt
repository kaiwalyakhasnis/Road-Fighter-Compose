package com.example.roadfightercompose.store.reducer

import androidx.compose.ui.geometry.Rect
import com.example.roadfightercompose.store.state.GreenCarState
import org.reduxkotlin.Action
import org.reduxkotlin.reducerFor

sealed class GreenCarActions : Action {
    data class UpdateBounds(
        val rect: Rect
    ) : GreenCarActions()
}

val greenCarReducer = reducerFor<GreenCarActions> { state, action ->
    when (action) {
        is GreenCarActions.UpdateBounds -> {
            val greenCarState = state.greenCarState.copy(bounds = action.rect)
            state.copy(greenCarState = greenCarState)
        }
    }
}