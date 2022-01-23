package sdl.moe.yabapi.api

import io.ktor.client.request.get
import io.ktor.client.request.parameter
import kotlinx.coroutines.withContext
import sdl.moe.yabapi.BiliClient
import sdl.moe.yabapi.consts.internal.LATEST_VIDEO_GET_URL
import sdl.moe.yabapi.consts.internal.RANKING_GET_URL
import sdl.moe.yabapi.data.GeneralCode.SUCCESS
import sdl.moe.yabapi.data.ranking.LatestVideoGetResponse
import sdl.moe.yabapi.data.ranking.RankingGetResponse
import sdl.moe.yabapi.enums.video.VideoType
import sdl.moe.yabapi.util.Logger
import kotlin.coroutines.CoroutineContext
import kotlin.native.concurrent.SharedImmutable

@SharedImmutable
private val logger by lazy { Logger("RankingApi") }

/**
 * 通過視頻分區獲得排行榜
 * @see VideoType
 */
public suspend fun BiliClient.getRanking(
    type: VideoType,
    day: Int = 3,
    context: CoroutineContext = this.context,
): RankingGetResponse = withContext(context) {
    logger.debug { "Getting Ranking for type ${type.name}, recent $day day(s)." }
    client.get<String>(RANKING_GET_URL) {
        parameter("rid", type.tid)
        parameter("day", day)
    }.deserializeJson<RankingGetResponse>().also {
        logger.debug { "Got Ranking for ${type.name}, recent $day day(s), count: ${it.data.count()}" }
        if (it.code != SUCCESS) logger.debug { "$it" }
        else logger.verbose { "$it" }
    }
}

/**
 * 通過視頻分區獲得最新發佈的視頻
 */
public suspend fun BiliClient.getLatestVideo(
    type: VideoType,
    page: Int = 1,
    countPerPage: Int = 5,
    context: CoroutineContext = this.context,
): LatestVideoGetResponse = withContext(context) {
    logger.debug { "Getting latest video for type ${type.name}, page $page..." }
    client.get<String>(LATEST_VIDEO_GET_URL) {
        parameter("pn", page)
        parameter("ps", countPerPage)
        parameter("rid", type.tid)
    }.deserializeJson<LatestVideoGetResponse>().also {
        logger.debug { "Got latest video for type ${type.name}, page $page, count: ${it.data?.archives?.count()}" }
        if (it.code != SUCCESS) logger.debug { "$it" }
        else logger.verbose { "$it" }
    }
}
