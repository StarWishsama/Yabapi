package moe.sdl.yabapi.data.sticker

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import moe.sdl.yabapi.data.GeneralCode

/**
 * 獲取所有表情包的返回
 * @param code 返回代碼
 * @param message 返回信息
 * @param ttl
 */
@Serializable
public data class AllStickersGetResponse(
    @SerialName("code") val code: GeneralCode,
    @SerialName("message") val message: String,
    @SerialName("ttl") val ttl: Int,
    @SerialName("data") val data: AllStickersGetResponseData? = null,
)

/**
 * @param owned 帳號擁有的表情包列表
 * @param all 所有表情包列表
 * @param mall [StickerMallData]
 */
@Serializable
public data class AllStickersGetResponseData(
    @SerialName("user_panel_packages") val owned: List<StickerSetData>,
    @SerialName("all_packages") val all: List<StickerSetData>,
    @SerialName("mall") val mall: StickerMallData,
)

/**
 * @param title 商城名稱
 * @param url 商城頁面Url
 */
@Serializable
public data class StickerMallData(
    @SerialName("title") val title: String,
    @SerialName("url") val url: String,
)
