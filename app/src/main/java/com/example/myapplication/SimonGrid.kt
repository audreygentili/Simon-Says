package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun SimonGrid(
    buttonsText: List<Char>,
    onButtonClick: (Char) -> Unit,
    lightButton: Char?,
    mode: SimonGridMode,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        items(buttonsText) { char ->
            val lightColor: Color = if (mode == SimonGridMode.PLAYER) {
                MaterialTheme.colorScheme.primary
            } else {
                if (char == lightButton) MaterialTheme.colorScheme.tertiary
                else Color.LightGray
            }
            Button(
                onClick = { onButtonClick(char) },
                shape = MaterialTheme.shapes.small,
                modifier = Modifier
                    .size(64.dp),
                enabled = mode == SimonGridMode.PLAYER,
                colors = ButtonDefaults.buttonColors(
                    disabledContainerColor = lightColor
                )
            ) {
                Text(text = if (char == lightButton) "($char)" else char.toString())
            }
        }
    }
}

@Preview
@Composable
fun SimonGridPreview() {
    val sequence = remember { mutableStateListOf<Char>() }
    MyApplicationTheme {
        Column {
            SimonGrid(
                buttonsText = ('a'..'p').toList(),
                onButtonClick = { sequence += it },
                lightButton = null,
                mode = SimonGridMode.PLAYER,
                modifier = Modifier
                    .background(Color.White)
            )
            Text("Sequence: ${sequence.joinToString("")}")
        }
    }
}

@Preview
@Composable
fun SimonGridLightPreview() {
    val sequence = remember { mutableStateListOf<Char>() }
    MyApplicationTheme {
        SimonGrid(
            buttonsText = ('a'..'p').toList(),
            onButtonClick = { },
            lightButton = 'a',
            mode = SimonGridMode.SYSTEM,
            modifier = Modifier
                .background(Color.White)
        )
    }
}

enum class SimonGridMode() {
    PLAYER,
    SYSTEM
}