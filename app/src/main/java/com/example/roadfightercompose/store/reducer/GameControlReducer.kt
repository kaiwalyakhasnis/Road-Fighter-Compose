package com.example.roadfightercompose.store.reducer

import com.example.roadfightercompose.store.state.GameControllerState
import com.example.roadfightercompose.store.type.ControllerButton
import mozilla.components.lib.state.Action

sealed class GameControlActions : Action {
    data class OnClicked(
        val button: ControllerButton
    ) : GameControlActions()

    object Reset: GameControlActions()
}

val gameControlReducer = reducerFor<GameControlActions> { state, action ->
    when (action) {
        is GameControlActions.OnClicked -> {
            state.copy(
                gameControllerState = GameControllerState(
                    playerOffset = state.gameControllerState.playerOffset + when (action.button) {
                        ControllerButton.Left -> -20f
                        ControllerButton.Right -> 20f
                        else -> 0f
                    }
                )
            )
        }
        is GameControlActions.Reset -> {
            state.copy(
                gameControllerState = GameControllerState(
                    playerOffset = 0f
                )
            )
        }
    }

}