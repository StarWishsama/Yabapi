package sdl.moe.yabapi.api

import io.ktor.client.request.get
import io.ktor.client.request.parameter
import kotlinx.coroutines.withContext
import sdl.moe.yabapi.BiliClient
import sdl.moe.yabapi.consts.internal.GET_ALL_STICKERS_URL
import sdl.moe.yabapi.data.sticker.AllStickersGetResponse
import sdl.moe.yabapi.enums.StickerBusiness
import sdl.moe.yabapi.util.Logger
import kotlin.coroutines.CoroutineContext
import kotlin.native.concurrent.SharedImmutable

@SharedImmutable
private val logger by lazy { Logger("StickerApi") }

/**
 * 表情包相关 API
 */

/**
 * 获取站内可用的所有表情包
 * 实际返回会根据用户而异, 并非真正的所有表情
 * @param business 使用場景 [StickerBusiness]
 */
public suspend fun BiliClient.getAllStickers(
    business: StickerBusiness,
    context: CoroutineContext = this.context,
): AllStickersGetResponse = withContext(context) {
    logger.debug { "Getting all stickers for business: $business" }
    client.get<String>(GET_ALL_STICKERS_URL) {
        parameter("business", business.toString())
    }.deserializeJson<AllStickersGetResponse>().also {
        logger.debug { "Got all stickers response: $it" }
    }
}
