package com.example.roadfightercompose.store

import com.example.roadfightercompose.store.middleware.GameRestartMiddleware
import com.example.roadfightercompose.store.reducer.gameReducer
import kotlinx.coroutines.Job
import mozilla.components.lib.state.Action
import mozilla.components.lib.state.Store

class GameStore(
    val gameRestartMiddleware: GameRestartMiddleware
) : Store<GameState, Action>(
    initialState = GameState(),
    reducer = gameReducer,
    middleware = listOf(
        gameRestartMiddleware
    )
)

fun interface StoreDispatcher {
    fun dispatch(action: Action): Job
}