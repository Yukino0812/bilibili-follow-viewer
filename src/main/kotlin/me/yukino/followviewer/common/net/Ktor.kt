package me.yukino.followviewer.common.net

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature

/**
 * @author Hoshiiro Yukino
 */

object Ktor {

    val client by lazy(LazyThreadSafetyMode.NONE) {
        HttpClient(CIO) {
            install(JsonFeature) {
                serializer = GsonSerializer()
            }
        }
    }

}