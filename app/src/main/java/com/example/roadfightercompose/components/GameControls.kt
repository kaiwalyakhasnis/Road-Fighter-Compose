package com.example.roadfightercompose.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.roadfightercompose.store.StoreDispatcher
import com.example.roadfightercompose.store.reducer.GameControlActions
import com.example.roadfightercompose.store.type.ControllerButton

@Composable
fun GameControls(
    modifier: Modifier = Modifier,
    storeDispatcher: StoreDispatcher
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = 10.dp,
                vertical = 100.dp
            ),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ControlButton(
            imageVector = Icons.Default.KeyboardArrowLeft,
            onClick = {
                storeDispatcher.dispatch(
                    GameControlActions.OnClicked(
                        ControllerButton.Left
                    )
                )
            }
        )

        ControlButton(
            imageVector = Icons.Default.KeyboardArrowRight,
            onClick = {
                storeDispatcher.dispatch(
                    GameControlActions.OnClicked(
                        ControllerButton.Right
                    )
                )
            }
        )
    }
}

@Composable
fun ControlButton(
    imageVector: ImageVector,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    IconButton(
        onClick = { onClick() },
        modifier = modifier
            .then(Modifier.size(75.dp))
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = CircleShape
            ),
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = Color.Gray
        )
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = "",
            tint = Color.Black,
            modifier = Modifier.size(75.dp)
        )
    }
}

@Preview
@Composable
fun ControlButtonPreview() {
    ControlButton(
        imageVector = Icons.Default.KeyboardArrowLeft,
        onClick = {}
    )
}