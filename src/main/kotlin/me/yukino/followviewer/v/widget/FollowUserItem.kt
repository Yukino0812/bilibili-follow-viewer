package me.yukino.followviewer.v.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.useResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.yukino.followviewer.common.ui.widget.AsyncImage
import me.yukino.followviewer.common.ui.widget.loadNetUrlImageBitmap

/**
 * @author Hoshiiro Yukino
 */

val noFaceImage by lazy(LazyThreadSafetyMode.NONE) { useResource("images/noface.jpg", ::loadImageBitmap) }

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FollowUserItem(
    faceImg : String,
    name: String,
    desc: String?,
    onClick : (() -> Unit)? = null
) {
    Card (
        modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
        elevation = 10.dp,
        onClick = { onClick?.invoke() }
    ) {
        Row (
            modifier = Modifier.padding(6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface (shape = CircleShape) {
                AsyncImage(
                    load = { loadNetUrlImageBitmap(faceImg) },
                    placeholder = noFaceImage,
                    // FIXME remember { painter }
                    painterFor = { BitmapPainter(it) },
                    contentDescription = name,
                    modifier = Modifier.size(50.dp)
                )
            }

            Spacer(Modifier.fillMaxHeight().width(12.dp))

            Column (Modifier.fillMaxWidth().wrapContentHeight()) {
                Text(
                    text = name,
                    fontSize = 16.sp,
                    color = Color(34, 34, 34),
                    maxLines = 1
                )
                if (desc?.isNotBlank() == true) {
                    Spacer(Modifier.fillMaxWidth().height(4.dp))
                    Text(
                        text = desc,
                        fontSize = 12.sp,
                        color = Color(109, 117, 122),
                        maxLines = 1
                    )
                }
            }
        }
    }
}