package com.example.roadfightercompose.store.reducer

import com.example.roadfightercompose.store.type.GameStatus
import mozilla.components.lib.state.Action

sealed class GameStatusActions : Action {
    data class Update(
        val status: GameStatus
    ) : GameStatusActions()
}

val gameStatusReducer = reducerFor<GameStatusActions> { state, action ->
    when(action){
        is GameStatusActions.Update -> {
            val gameStatusState = state.gameStatusState.copy(status = action.status)
            state.copy(gameStatusState = gameStatusState)
        }
    }
}