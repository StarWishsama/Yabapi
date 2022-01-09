// © Copyright 2021-2022 Colerar and repository contributors
// Use of this source code is governed by the CDDL license that can be found via link below:
// https://github.com/SDLMoe/Yabapi/blob/master/LICENSE

package sdl.moe.yabapi.api

import sdl.moe.yabapi.api.InfoApi.getBasicInfo
import sdl.moe.yabapi.api.LiveApi.createLiveDanmakuConnection
import sdl.moe.yabapi.api.LiveApi.getLiveDanmakuInfo
import sdl.moe.yabapi.api.LiveApi.getRoomInitInfo
import sdl.moe.yabapi.client
import sdl.moe.yabapi.config.LiveDanmakuSocketConfig
import sdl.moe.yabapi.config.onCommandResponse
import sdl.moe.yabapi.initTest
import sdl.moe.yabapi.runTest
import kotlin.test.Test

internal class LiveApiTest {
    init {
        initTest()
    }

    suspend fun createConnection(roomId: Int, config: LiveDanmakuSocketConfig.() -> Unit = {}) {
        val realId = client.getRoomInitInfo(roomId).data?.roomId ?: error("Get init info failed")
        val danmakuInfoData = client.getLiveDanmakuInfo(realId).data ?: error("Get live server failed")
        val loginUserMid = client.getBasicInfo().data.mid ?: error("Not login")
        client.createLiveDanmakuConnection(loginUserMid,
            realId,
            danmakuInfoData.token,
            danmakuInfoData.hostList[0],
            config)
    }

    @Test
    fun getRoomInitInfoTest() {
        runTest {
            client.getRoomInitInfo(213)
        }
    }

    @Test
    fun connectTest() {
        runTest {
            val roomId = 4788550
            createConnection(roomId)
        }
    }

    @Test
    fun serializeTest() {
        runTest {
            val roomId = 33989
            createConnection(roomId) {
                onCommandResponse { flow ->
                    // flow.collect {}
                }
            }
        }
    }
}
