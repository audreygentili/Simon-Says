package com.example.myapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SimonViewModel : ViewModel() {

    private val _state = MutableStateFlow(
        SimonState(
            mode = SimonGridMode.SYSTEM,
            lightButton = null,
            buttonsText = ('a'..'p').toList()
        )
    )
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            delay(1000)
            lightButton('a')
            lightButton('b')
            lightButton('c')
            lightButton('d')
            _state.update {
                it.copy(
                    mode = SimonGridMode.PLAYER
                )
            }
        }
    }

    private suspend fun lightButton(char: Char) {
        _state.update {
            it.copy(lightButton = char)
        }
        delay(1500)
        _state.update {
            it.copy(lightButton = null)
        }
        delay(200)
    }
}

data class SimonState(
    val mode: SimonGridMode,
    val lightButton: Char?,
    val buttonsText: List<Char>
)