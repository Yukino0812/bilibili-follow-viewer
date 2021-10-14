package me.yukino.followviewer.vm

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

/**
 * @author Hoshiiro Yukino
 */

object LayoutStateViewModel {

    var state : MutableState<State> = mutableStateOf(State.Search)

    fun navigateTo(state: State) {
        this.state.value = state
    }

    enum class State {
        Search, Result
    }

}