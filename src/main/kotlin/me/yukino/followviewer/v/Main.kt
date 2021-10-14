package me.yukino.followviewer.v

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import me.yukino.followviewer.v.layout.SearchLayout
import me.yukino.followviewer.v.layout.SearchResultLayout
import me.yukino.followviewer.vm.LayoutStateViewModel

@Composable
@Preview
fun App() {
    MaterialTheme {
        when (LayoutStateViewModel.state.value) {
            LayoutStateViewModel.State.Search -> SearchLayout()
            LayoutStateViewModel.State.Result -> SearchResultLayout()
        }
    }
}

fun main() = application {
    Window(
        title = "关注列表查询",
        onCloseRequest = ::exitApplication
    ) {
        App()
    }
}
