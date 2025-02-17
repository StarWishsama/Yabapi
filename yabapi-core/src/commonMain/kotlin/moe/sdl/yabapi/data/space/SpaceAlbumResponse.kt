package moe.sdl.yabapi.data.space

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import moe.sdl.yabapi.data.GeneralCode
import moe.sdl.yabapi.data.GeneralCode.UNKNOWN
import moe.sdl.yabapi.data.album.AlbumPicture

@Serializable
public data class SpaceAlbumResponse(
    @SerialName("code") val code: GeneralCode = UNKNOWN,
    @SerialName("message") val message: String? = null,
    @SerialName("ttl") val ttl: Int? = null,
    @SerialName("data") val data: List<AlbumItem> = emptyList(),
)

@Serializable
public data class AlbumItem(
    @SerialName("doc_id") val docId: Int,
    @SerialName("poster_uid") val posterUid: Int,
    @SerialName("title") val title: String,
    @SerialName("description") val description: String,
    @SerialName("pictures") val pictures: List<AlbumPicture> = emptyList(),
    @SerialName("count") val count: Int,
    @SerialName("ctime") val createdTime: Long,
    @SerialName("view") val view: Int,
    @SerialName("like") val like: Int,
)
