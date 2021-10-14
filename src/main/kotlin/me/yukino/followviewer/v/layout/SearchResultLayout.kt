package me.yukino.followviewer.v.layout

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import java.awt.Desktop
import java.net.URI
import me.yukino.followviewer.v.widget.FollowUserItem
import me.yukino.followviewer.vm.BilibiliViewerViewModel
import me.yukino.followviewer.vm.LayoutStateViewModel

/**
 * @author Hoshiiro Yukino
 */

@Composable
@Preview
fun SearchResultLayout() {

    Column {

        TopAppBar(
            title = {
                Text("查询结果")
            },
            navigationIcon = {
                IconButton(
                    onClick = {
                        LayoutStateViewModel.navigateTo(LayoutStateViewModel.State.Search)
                    }
                ) {
                    Icon(Icons.Filled.ArrowBack, null)
                }
            }
        )

        val list = BilibiliViewerViewModel.followingVO.value?.data?.list?.filterNotNull()
        if (list != null && list.isNotEmpty()) {
            LazyColumn {
                items(list.size) { index ->
                    val item = list[index]
                    FollowUserItem(
                        faceImg = item.face ?: "",
                        name = item.uname ?: "",
                        desc = item.official_verify?.desc,
                        onClick = {
                            item.mid?.let {
                                Desktop.getDesktop().browse(URI("https://space.bilibili.com/$it"))
                            }
                        }
                    )
                }
            }


        }
    }

}