@file:UseSerializers(BooleanJsSerializer::class)

package moe.sdl.yabapi.data.feed.cards

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import moe.sdl.yabapi.data.info.UserVip
import moe.sdl.yabapi.enums.feed.FeedType
import moe.sdl.yabapi.serializer.BooleanJsSerializer

@Serializable
public data class ImageCard(
    @SerialName("item") val item: Item,
    @SerialName("user") val user: User,
): FeedCard {
    @Serializable
    public data class Item(
        @SerialName("at_control") val atControl: String? = null,
        @SerialName("category") val category: String,
        @SerialName("description") val description: String, // 內容
        @SerialName("id") val id: Int,
        @SerialName("is_fav") val isFav: Boolean,
        @SerialName("pictures") val pictures: List<CardPicture>,
        @SerialName("pictures_count") val picturesCount: Int,
        @SerialName("reply") val reply: Int,
        @SerialName("role") val role: JsonArray,
        @SerialName("settings") val settings: Settings,
        @SerialName("source") val source: JsonArray,
        @SerialName("title") val title: String,
        @SerialName("upload_time") val uploadTime: Long,
    )

    @Serializable
    public data class Settings(
        @SerialName("copy_forbidden") private val _copyForbidden: String,
    ) {
        val copyForbidden: Boolean by lazy { _copyForbidden == "1" }
    }

    @Serializable
    public data class User(
        @SerialName("head_url") val headUrl: String,
        @SerialName("name") val name: String,
        @SerialName("uid") val uid: Int,
        @SerialName("vip") val vip: UserVip,
    )

    public companion object : FeedCardFactory() {
        override val code: Int = FeedType.IMAGE.code
        override fun decode(json: Json, data: String): ImageCard = json.decodeFromString(data)
    }
}

@Serializable
public data class CardPicture(
    @SerialName("img_height") val imgHeight: Int,
    @SerialName("img_size") val imgSize: Double,
    @SerialName("img_src") val imgSrc: String,
    @SerialName("img_tags") val imgTags: JsonElement? = null,
    @SerialName("img_width") val imgWidth: Int,
)
