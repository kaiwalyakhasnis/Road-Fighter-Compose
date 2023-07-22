package com.example.roadfightercompose.store.type

sealed class GameStatus {
    object Running: GameStatus()
    object Finish: GameStatus()
}