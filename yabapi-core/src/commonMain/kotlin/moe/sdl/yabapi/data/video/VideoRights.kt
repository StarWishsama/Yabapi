@file:UseSerializers(BooleanJsSerializer::class)

package moe.sdl.yabapi.data.video

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import moe.sdl.yabapi.serializer.BooleanJsSerializer

@Serializable
public data class VideoRights(
    @SerialName("bp") val bp: Int,
    @SerialName("elec") val canCharge: Boolean,
    @SerialName("download") val canDownload: Boolean,
    @SerialName("movie") val isMovie: Boolean,
    @SerialName("pay") val needPay: Boolean,
    @SerialName("hd5") val isHighBitrate: Boolean,
    @SerialName("no_reprint") val showNoReprint: Boolean,
    @SerialName("autoplay") val isAutoplay: Boolean,
    @SerialName("ugc_pay") val isUgcPay: Boolean,
    @SerialName("is_stein_gate") val isInteractive: Boolean? = null,
    @SerialName("is_cooperation") val isCooperation: Boolean,
    @SerialName("ugc_pay_preview") val canPayPreview: Boolean,
    @SerialName("no_background") val noBackground: Boolean? = null,
    @SerialName("clean_mode") val isCleanMode: Boolean? = null,
    @SerialName("is_360") val isPanoramic: Boolean? = null,
    @SerialName("no_share") val noShare: Boolean? = null,
)
