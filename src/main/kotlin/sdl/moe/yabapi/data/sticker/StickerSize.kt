// © Copyright 2021 Colerar and repository contributors
// Use of this source code is governed by the MIT license that can be found via link below:
// https://github.com/SDLMoe/Yabapi/blob/master/LICENSE

package sdl.moe.yabapi.data.sticker

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sdl.moe.yabapi.data.sticker.StickerSize.LARGE
import sdl.moe.yabapi.data.sticker.StickerSize.SMALL

/**
 * 表情大小
 * @property SMALL 小
 * @property LARGE 大
 */
@Serializable
public enum class StickerSize {
    UNKNOWN,

    @SerialName("1")
    SMALL,

    @SerialName("2")
    LARGE;
}
