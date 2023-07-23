package com.example.roadfightercompose.store.middleware

import com.example.roadfightercompose.store.GameState
import com.example.roadfightercompose.store.reducer.LevelActions
import com.example.roadfightercompose.store.reducer.ScoreActions
import mozilla.components.lib.state.Action
import mozilla.components.lib.state.Middleware
import mozilla.components.lib.state.MiddlewareContext

class LevelsMiddleware : Middleware<GameState, Action> {
    override fun invoke(
        context: MiddlewareContext<GameState, Action>,
        next: (Action) -> Unit,
        action: Action
    ) {
        next(action)

        when (action) {
            is ScoreActions.Increment -> {
                val score = context.state.scoreState.score
                if (score.mod(25) == 0) {
                    context.store.dispatch(
                        LevelActions.Increment
                    )
                }
            }

            is ScoreActions.Reset -> {
                context.store.dispatch(
                    LevelActions.Reset
                )
            }
        }
    }
}