// © Copyright 2021 Colerar and repository contributors
// Use of this source code is governed by the MIT license that can be found via link below:
// https://github.com/SDLMoe/Yabapi/blob/master/LICENSE

package sdl.moe.yabapi.api

import io.ktor.client.request.get
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import mu.KotlinLogging
import sdl.moe.yabapi.BiliClient
import sdl.moe.yabapi.consts.info.BASIC_INFO_GET_URL
import sdl.moe.yabapi.data.info.BasicInfoGetResponse

private val logger = KotlinLogging.logger {}

public object InfoApi : BiliApi {
    init {
        BiliClient.registerApi(this)
    }

    override val apiName: String = "info"

    @Suppress("unused")
    public val BiliClient.infoApi: InfoApi
        get() = this@InfoApi

    @JvmName("getBasicInfoExt")
    public suspend fun BiliClient.getBasicInfo(): BasicInfoGetResponse = withContext(Dispatchers.IO) {
        logger.info { "Getting basic info..." }
        client.get<BasicInfoGetResponse>(BASIC_INFO_GET_URL).also {
            logger.debug { "Basic info response: $it" }
        }
    }

    @JvmName("getBasicInfo")
    public suspend fun getBasicInfo(client: BiliClient): BasicInfoGetResponse = client.getBasicInfo()
}
