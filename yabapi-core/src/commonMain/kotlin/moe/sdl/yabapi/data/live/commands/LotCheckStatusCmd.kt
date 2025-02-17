package moe.sdl.yabapi.data.live.commands

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromJsonElement
import moe.sdl.yabapi.data.live.commands.LotStatus.UNKNOWN

@Serializable
public data class LotCheckStatusCmd(
    @SerialName("cmd") override val operation: String,
    @SerialName("data") val data: LotStatusData,
) : LiveCommand {
    public companion object : LiveCommandFactory() {
        override val operation: String = "ANCHOR_LOT_CHECKSTATUS"
        override fun decode(json: Json, data: JsonElement): LotCheckStatusCmd = json.decodeFromJsonElement(data)
    }
}

@Serializable
public data class LotStatusData(
    @SerialName("id") val id: Int,
    @SerialName("reject_reason") val rejectReason: String? = null, // 若 status 爲 REVIEW FAILED 則存在
    @SerialName("status") val status: LotStatus = UNKNOWN,
    @SerialName("uid") val uid: Int, // 主播 Uid
)
