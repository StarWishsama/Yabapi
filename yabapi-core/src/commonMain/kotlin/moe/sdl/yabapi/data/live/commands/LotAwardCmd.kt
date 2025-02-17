package moe.sdl.yabapi.data.live.commands

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromJsonElement
import moe.sdl.yabapi.data.RgbColor
import moe.sdl.yabapi.data.live.commands.LotStatus.UNKNOWN
import moe.sdl.yabapi.serializer.data.RgbColorIntSerializer

@Serializable
public data class LotAwardCmd(
    @SerialName("cmd") override val operation: String,
    @SerialName("data") val data: LotAwardData,
) : LiveCommand {
    public companion object : LiveCommandFactory() {
        override val operation: String = "ANCHOR_LOT_AWARD"
        override fun decode(json: Json, data: JsonElement): LotAwardCmd = json.decodeFromJsonElement(data)
    }
}

@Serializable
public data class LotAwardData(
    @SerialName("award_image") val image: String,
    @SerialName("award_name") val name: String,
    @SerialName("award_num") val count: Int, // 應該是獎品個數
    @SerialName("award_users") val users: List<LotAwardUser>,
    @SerialName("id") val id: Int,
    @SerialName("lot_status") val status: LotStatus = UNKNOWN,
    @SerialName("url") val url: String,
    @SerialName("web_url") val webUrl: String,
)

@Serializable
public data class LotAwardUser(
    @SerialName("uid") val uid: Int,
    @SerialName("uname") val uname: String,
    @SerialName("face") val avatar: String,
    @SerialName("level") val level: Int,
    @Serializable(RgbColorIntSerializer::class)
    @SerialName("color") val color: RgbColor,
)
