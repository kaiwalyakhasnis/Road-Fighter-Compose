package com.example.roadfightercompose

import androidx.lifecycle.ViewModel
import com.example.roadfightercompose.store.GameStore
import com.example.roadfightercompose.store.StoreDispatcher
import com.example.roadfightercompose.store.middleware.GameRestartMiddleware
import com.example.roadfightercompose.store.middleware.LevelsMiddleware

class GameViewModel : ViewModel() {
    val gameStore by lazy {
        GameStore(
            gameRestartMiddleware = GameRestartMiddleware(),
            levelsMiddleware = LevelsMiddleware()
        )
    }
    val storeDispatcher = StoreDispatcher(gameStore::dispatch)
}