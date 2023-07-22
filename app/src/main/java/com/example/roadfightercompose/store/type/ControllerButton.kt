package com.example.roadfightercompose.store.type

sealed class ControllerButton {
    object Left: ControllerButton()
    object Right: ControllerButton()
    object None: ControllerButton()
}