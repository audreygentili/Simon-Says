package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun SimonCase(
    buttonsText: List<Char>,
    onButtonClick: (Char) -> Unit,
    lightButton: Char?,
    mode: SimonGridMode,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = CenterHorizontally
    ) {
        SimonGrid(
            buttonsText = buttonsText,
            onButtonClick = onButtonClick,
            lightButton = lightButton,
            mode = mode
        )
        if (mode == SimonGridMode.PLAYER) {
            SimonIncentive(text = "A toi !")
        } else {
            SimonIncentive(text = "Écoute")
        }
    }
}

@Composable
fun SimonIncentive(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        modifier = modifier
            .padding(16.dp),
        style = MaterialTheme.typography.displaySmall
    )
}

@Preview
@Composable
fun SimonCasePlayerPreview() {
    MyApplicationTheme {
        SimonCase(
            buttonsText = ('a'..'p').toList(),
            onButtonClick = { },
            lightButton = null,
            mode = SimonGridMode.PLAYER,
            modifier = Modifier
                .background(Color.White)
        )
    }
}

@Preview
@Composable
fun SimonCaseSystemPreview() {
    MyApplicationTheme {
        SimonCase(
            buttonsText = ('a'..'p').toList(),
            onButtonClick = { },
            lightButton = null,
            mode = SimonGridMode.SYSTEM,
            modifier = Modifier
                .background(Color.White)
        )
    }
}