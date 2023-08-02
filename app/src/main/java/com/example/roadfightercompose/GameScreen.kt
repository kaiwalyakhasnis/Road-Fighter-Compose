package com.example.roadfightercompose

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.roadfightercompose.components.BlueCar
import com.example.roadfightercompose.components.BusyRoad
import com.example.roadfightercompose.components.DashBoard
import com.example.roadfightercompose.components.GameControls
import com.example.roadfightercompose.components.GameOver
import com.example.roadfightercompose.components.PlayerCar
import com.example.roadfightercompose.store.state.LevelsState
import com.example.roadfightercompose.store.type.GameStatus
import mozilla.components.lib.state.ext.observeAsComposableState

@Composable
fun GameScreen(
    gameViewModel: GameViewModel = viewModel()
) {
    val status = gameViewModel.gameStore.observeAsComposableState(
        map = { state -> state.gameStatusState }
    )
    val score = gameViewModel.gameStore.observeAsComposableState(
        map = { state -> state.scoreState }
    ).value?.score ?: 0

    val levelState = gameViewModel.gameStore.observeAsComposableState(
        map = { state -> state.levelsState }
    ).value ?: LevelsState()

    when (status.value?.status) {
        is GameStatus.Running -> {
            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.Black)
            ) {
                val transition = rememberInfiniteTransition()
                // this acts as game loop
                val animation = transition.animateFloat(
                    initialValue = 0f,
                    targetValue = 1f,
                    animationSpec = infiniteRepeatable(
                        animation = tween(
                            durationMillis = levelState.getCurrentLevelData().speed,
                            easing = LinearEasing
                        )
                    )
                )

                // road along with traffic
                BusyRoad(
                    height = maxHeight,
                    width = maxWidth,
                    storeDispatcher = gameViewModel.storeDispatcher,
                    animation = animation.value,
                    roadColorFilter = levelState.getCurrentLevelData().roadColorFilter
                )

                // blue car
                BlueCar(
                    animation = animation.value,
                    height = maxHeight,
                    storeDispatcher = gameViewModel.storeDispatcher
                )

                // red car
                PlayerCar(
                    modifier = Modifier.align(
                        alignment = Alignment.BottomCenter
                    ),
                    storeDispatcher = gameViewModel.storeDispatcher,
                    blueCarState = gameViewModel.gameStore.observeAsComposableState(
                        map = { state -> state.blueCarState }
                    ).value,
                    roadState = gameViewModel.gameStore.observeAsComposableState(
                        map = { state -> state.roadState }
                    ).value,
                    playerOffset = gameViewModel.gameStore.observeAsComposableState(
                        map = { state -> state.gameControllerState }
                    ).value?.playerOffset
                )

                GameControls(
                    modifier = Modifier.align(Alignment.BottomStart),
                    storeDispatcher = gameViewModel.storeDispatcher
                )

                // score and level
                DashBoard(
                    modifier = Modifier.align(Alignment.TopStart),
                    score = score,
                    level = levelState.getCurrentLevelData().level
                )
            }
        }

        is GameStatus.Finish -> {
            GameOver(
                score = score,
                storeDispatcher = gameViewModel.storeDispatcher
            )
        }

        else -> {
            // do nothing
        }
    }
}
