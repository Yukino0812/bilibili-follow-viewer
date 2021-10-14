package me.yukino.followviewer.m

import io.ktor.client.request.get
import me.yukino.followviewer.common.net.Ktor
import me.yukino.followviewer.m.vo.BilibiliFollowingVO

/**
 * @author Hoshiiro Yukino
 */

object BiliBiliViewerRepo {

    suspend fun getFollowingData(uid: String): BilibiliFollowingVO? {
        return Ktor.client.get<BilibiliFollowingVO>("https://api.bilibili.com/x/relation/followings?vmid=$uid")
    }

}