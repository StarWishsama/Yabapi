package moe.sdl.yabapi.data.feed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import moe.sdl.yabapi.data.info.LevelInfo
import moe.sdl.yabapi.data.info.Pendant

@Serializable
public data class FeedUserProfile(
    @SerialName("info") val info: UserInfo,
    @SerialName("card") val card: FeedUserCard? = null,
    @SerialName("vip") val vip: FeedVip? = null,
    @SerialName("pendant") val pendant: Pendant? = null,
    @SerialName("decorate_card") val decorateCard: FeedDecorateCard? = null,
    @SerialName("rank") val rank: String? = null,
    @SerialName("sign") val sign: String? = null,
    @SerialName("level_info") val levelInfo: LevelInfo? = null,
)
