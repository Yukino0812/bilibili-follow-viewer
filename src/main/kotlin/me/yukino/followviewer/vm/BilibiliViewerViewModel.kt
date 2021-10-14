package me.yukino.followviewer.vm

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import me.yukino.followviewer.m.BiliBiliViewerRepo
import me.yukino.followviewer.m.vo.BilibiliFollowingVO

/**
 * @author Hoshiiro Yukino
 */

object BilibiliViewerViewModel {

    var followingVO : MutableState<BilibiliFollowingVO?> = mutableStateOf(null)

    /**
     * TODO 需要支持分页，接口最多返回50条数据
     */
    fun getFollowingData(uid: String) {
        followingVO.value = null
        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                val res = BiliBiliViewerRepo.getFollowingData(uid)
                println(res)
                followingVO.value = res
            }
        }
    }

}