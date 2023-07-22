package com.example.roadfightercompose.store.reducer

import com.example.roadfightercompose.store.state.ScoreState
import mozilla.components.lib.state.Action

sealed class ScoreActions : Action {
    object Increment : ScoreActions()
    object Reset : ScoreActions()
}

val scoreReducer = reducerFor<ScoreActions> { state, action ->
    when (action) {
        is ScoreActions.Increment -> {
            state.copy(scoreState = ScoreState(state.scoreState.score + 1))
        }

        is ScoreActions.Reset -> {
            state.copy(scoreState = ScoreState(0))
        }
    }
}