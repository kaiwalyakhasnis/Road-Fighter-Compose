package com.example.roadfightercompose.store.reducer

val gameReducer = combineReducers(
    roadReducer,
    blueCarReducer,
    gameStatusReducer,
    scoreReducer,
    gameControlReducer
)