package moe.sdl.yabapi.data.live.commands

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromJsonElement
import moe.sdl.yabapi.data.live.GuardLevel
import moe.sdl.yabapi.data.live.GuardLevel.UNKNOWN

/**
 * 高能榜 V2 数据
 */
@Serializable
public data class OnlineRankV2Cmd(
    @SerialName("cmd") override val operation: String,
    @SerialName("data") val data: OnlineRankV2,
) : LiveCommand {
    public companion object : LiveCommandFactory() {
        override val operation: String = "ONLINE_RANK_V2"
        override fun decode(json: Json, data: JsonElement): OnlineRankV2Cmd = json.decodeFromJsonElement(data)
    }
}

@Serializable
public data class OnlineRankV2(
    @SerialName("list") val list: List<OnlineRankV2Node> = emptyList(),
    @SerialName("rank_type") val rankType: String,
) {
    @Serializable
    public data class OnlineRankV2Node(
        @SerialName("uid") val uid: Int,
        @SerialName("face") val avatar: String,
        @SerialName("score") val score: String,
        @SerialName("uname") val uname: String,
        @SerialName("rank") val rank: Int,
        @SerialName("guard_level") val guardLevel: GuardLevel = UNKNOWN,
    )
}
