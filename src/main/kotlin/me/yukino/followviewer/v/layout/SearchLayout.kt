package me.yukino.followviewer.v.layout

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import me.yukino.followviewer.vm.BilibiliViewerViewModel
import me.yukino.followviewer.vm.LayoutStateViewModel

/**
 * @author Hoshiiro Yukino
 */

@Composable
@Preview
fun SearchLayout() {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            var searchContent by remember { mutableStateOf("12345678") }

            TextField(
                label = {
                        Text("UID")
                },
                value = searchContent,
                onValueChange = {
                    searchContent = it
                },
                modifier = Modifier.fillMaxWidth(0.8F),
                singleLine = true
            )

            Button(
                onClick = {
                    BilibiliViewerViewModel.getFollowingData(searchContent)
                    LayoutStateViewModel.navigateTo(LayoutStateViewModel.State.Result)
                },
                modifier = Modifier.padding(20.dp)
            ){
                Text("查询")
            }

        }

    }

}