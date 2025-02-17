@file:UseSerializers(BooleanJsSerializer::class)

package moe.sdl.yabapi.data.video

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import moe.sdl.yabapi.serializer.BooleanJsSerializer

@Serializable
public data class VideoSubtitle(
    @SerialName("allow_submit") val allowSubmit: Boolean,
    @SerialName("list") val list: List<SubtitleTrack>,
)

@Serializable
public data class SubtitleTrack(
    @SerialName("id") val id: Int,
    @SerialName("lan") val language: String,
    @SerialName("lan_doc") val languageName: String,
    @SerialName("is_lock") val isLocked: Boolean,
    @SerialName("author_mid") val authorMid: Int,
    @SerialName("subtitle_url") val subtitleUrl: String,
    @SerialName("author") val author: SubtitleAuthor,
)

@Serializable
public data class SubtitleAuthor(
    @SerialName("mid") val mid: Int,
    @SerialName("name") val name: String,
    @SerialName("sex") val sex: String,
    @SerialName("face") val avatar: String,
    @SerialName("sign") val bio: String,
    @SerialName("rank") val rank: Int,
    @SerialName("birthday") val birthday: Int,
    @SerialName("is_fake_account") val isFakeAccount: Boolean,
    @SerialName("is_deleted") val isDeleted: Boolean,
)
