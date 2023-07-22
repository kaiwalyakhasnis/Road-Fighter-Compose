package com.example.roadfightercompose.store.reducer

import com.example.roadfightercompose.store.GameState
import mozilla.components.lib.state.Action
import mozilla.components.lib.state.Reducer

open class ReducerWrapper<A : Action>(
    val actionType: String,
    reducer: Reducer<GameState, A>
) : Reducer<GameState, A> by reducer

inline fun <reified A : Action> reducerFor(
    crossinline reducer: (
        state: GameState, action: A
    ) -> GameState
): ReducerWrapper<A> {
    return ReducerWrapper(
        actionType = A::class.java.simpleName,
        reducer = object : Reducer<GameState, A> {
            override fun invoke(state: GameState, action: A): GameState {
                return reducer(state, action)
            }
        })
}


fun <A : Action> combineReducers(
    vararg reducers: ReducerWrapper<in A>
): Reducer<GameState, Action> {
    val map = reducers.groupBy { it.actionType }

    return object : Reducer<GameState, Action> {
        @Suppress("UNCHECKED_CAST")
        override fun invoke(state: GameState, action: Action): GameState {
            return map[action.javaClass.superclass.simpleName]
                ?.fold(state) { next, reducer ->
                    reducer.invoke(next, action as A)
                } ?: state
        }
    }
}