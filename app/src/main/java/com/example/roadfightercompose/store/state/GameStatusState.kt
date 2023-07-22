package com.example.roadfightercompose.store.state

import com.example.roadfightercompose.store.type.GameStatus

data class GameStatusState(
    val status: GameStatus = GameStatus.Running
)