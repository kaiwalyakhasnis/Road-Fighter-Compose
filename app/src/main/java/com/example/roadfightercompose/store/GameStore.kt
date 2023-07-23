package com.example.roadfightercompose.store

import com.example.roadfightercompose.store.middleware.GameRestartMiddleware
import com.example.roadfightercompose.store.middleware.LevelsMiddleware
import com.example.roadfightercompose.store.reducer.gameReducer
import kotlinx.coroutines.Job
import mozilla.components.lib.state.Action
import mozilla.components.lib.state.Store

class GameStore(
    gameRestartMiddleware: GameRestartMiddleware,
    levelsMiddleware: LevelsMiddleware,
) : Store<GameState, Action>(
    initialState = GameState(),
    reducer = gameReducer,
    middleware = listOf(
        gameRestartMiddleware,
        levelsMiddleware
    )
)

fun interface StoreDispatcher {
    fun dispatch(action: Action): Job
}