package com.example.myapplication

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun SimonSays() {
    val viewModel = remember { SimonViewModel() }
    val state by viewModel.state.collectAsState()

    SimonCase(
        buttonsText = state.buttonsText,
        onButtonClick = {},
        lightButton = state.lightButton,
        mode = state.mode,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    )
}

@Preview
@Composable
fun SimonSaysPreview() {
    MyApplicationTheme {
        SimonSays()
    }
}