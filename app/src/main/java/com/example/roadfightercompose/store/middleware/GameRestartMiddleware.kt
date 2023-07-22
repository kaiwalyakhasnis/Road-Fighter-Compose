package com.example.roadfightercompose.store.middleware

import com.example.roadfightercompose.store.GameState
import com.example.roadfightercompose.store.reducer.GameControlActions
import com.example.roadfightercompose.store.reducer.GameStatusActions
import com.example.roadfightercompose.store.reducer.ScoreActions
import com.example.roadfightercompose.store.type.GameStatus
import mozilla.components.lib.state.Action
import mozilla.components.lib.state.Middleware
import mozilla.components.lib.state.MiddlewareContext

class GameRestartMiddleware : Middleware<GameState, Action> {
    override fun invoke(
        context: MiddlewareContext<GameState, Action>,
        next: (Action) -> Unit,
        action: Action
    ) {
        when (action) {
            is GameStatusActions.Update -> {
                if (action.status is GameStatus.Running) {
                    context.store.dispatch(
                        ScoreActions.Reset
                    )
                    context.store.dispatch(
                        GameControlActions.Reset
                    )
                }
            }
        }
        next(action)
    }
}