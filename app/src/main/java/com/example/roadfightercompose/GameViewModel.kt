package com.example.roadfightercompose

import androidx.lifecycle.ViewModel
import com.example.roadfightercompose.store.GameStore
import com.example.roadfightercompose.store.StoreDispatcher
import com.example.roadfightercompose.store.middleware.GameRestartMiddleware

class GameViewModel : ViewModel() {
    val gameStore by lazy {
        GameStore(
            gameRestartMiddleware = GameRestartMiddleware()
        )
    }
    val storeDispatcher = StoreDispatcher(gameStore::dispatch)
}