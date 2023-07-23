package com.example.roadfightercompose.store

import com.example.roadfightercompose.store.state.BlueCarState
import com.example.roadfightercompose.store.state.GameControllerState
import com.example.roadfightercompose.store.state.GameStatusState
import com.example.roadfightercompose.store.state.LevelsState
import com.example.roadfightercompose.store.state.RoadState
import com.example.roadfightercompose.store.state.ScoreState
import com.example.roadfightercompose.store.type.ReduxState

data class GameState(
    val blueCarState: BlueCarState = BlueCarState(),
    val roadState: RoadState = RoadState(),
    val gameStatusState: GameStatusState = GameStatusState(),
    val scoreState: ScoreState = ScoreState(),
    val gameControllerState: GameControllerState = GameControllerState(),
    val levelsState: LevelsState = LevelsState()
): ReduxState