package me.yukino.followviewer.common.ui.widget

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.loadImageBitmap
import io.ktor.client.request.get
import java.io.File
import java.io.IOException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import me.yukino.followviewer.common.net.Ktor

/**
 * @author Hoshiiro Yukino
 */

@Composable
fun <T> AsyncImage(
    load: suspend () -> T,
    placeholder: T,
    painterFor: @Composable (T) -> Painter,
    contentDescription: String,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit,
) {
    var imageState by remember { mutableStateOf(placeholder) }

    produceState(null) {
        withContext(Dispatchers.IO) {
            try {
                load()
            } catch (e: IOException) {
                e.printStackTrace()
                null
            }
        }?.let { imageState = it }
    }

    Image(
        painter = painterFor(imageState),
        contentDescription = contentDescription,
        contentScale = contentScale,
        modifier = modifier
    )
}

fun loadImageBitmap(file: File): ImageBitmap =
    file.inputStream().buffered().use(::loadImageBitmap)

suspend fun loadNetUrlImageBitmap(url: String): ImageBitmap =
    Ktor.client.get<ByteArray>(url).let {
        org.jetbrains.skia.Image.makeFromEncoded(it)
    }.toComposeImageBitmap()
