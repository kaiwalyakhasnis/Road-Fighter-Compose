package com.example.roadfightercompose.store.type

sealed class RoadSectionType {
    object Left : RoadSectionType()
    object Right : RoadSectionType()
    object Center : RoadSectionType()
}