package moe.sdl.yabapi.data.video

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import moe.sdl.yabapi.data.video.VideoComboLikeCode.UNKNOWN

@Serializable
public data class VideoComboLikeResponse(
    @SerialName("code") val code: VideoComboLikeCode = UNKNOWN,
    @SerialName("message") val message: String? = null,
    @SerialName("ttl") val ttl: Int? = null,
    @SerialName("data") val data: VideoComboLikeData? = null,
)

@Serializable
public data class VideoComboLikeData(
    @SerialName("like") val isLike: Boolean,
    @SerialName("coin") val isCoined: Boolean,
    @SerialName("fav") val isCollected: Boolean,
    @SerialName("multiply") val coinCount: Int,
)

@Serializable
public enum class VideoComboLikeCode {
    UNKNOWN,

    @SerialName("0")
    SUCCESS,

    @SerialName("-101")
    NOT_LOGIN,

    @SerialName("-111")
    CSRF_INVALID,

    @SerialName("-400")
    REQUEST_ERROR,

    @SerialName("10003")
    NO_SUCH_VIDEO,
}
