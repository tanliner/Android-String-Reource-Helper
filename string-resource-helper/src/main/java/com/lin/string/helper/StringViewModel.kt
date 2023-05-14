package com.lin.string.helper

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class StringViewModel : ViewModel() {

    private val _display = MutableStateFlow<TextForUI?>(null)
    val display: StateFlow<TextForUI?>
        get() = _display.asStateFlow()

    init {
        doSomeFetch()
    }

    private fun doSomeFetch() {
        viewModelScope.launch {
            flow {
                emit("located" to "China")
            }.collect { pair ->
                _display.update {
                    TextForUI(R.string.user_current_state, pair.first, pair.second)
                }
            }
        }
    }
}


internal class TextForUI(
    val resId: Int,
    vararg val args: Any
) {

    @Composable
    fun asString() = stringResource(resId, *args)
}
