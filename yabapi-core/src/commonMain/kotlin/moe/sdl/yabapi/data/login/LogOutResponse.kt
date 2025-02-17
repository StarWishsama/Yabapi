@file:UseSerializers(BooleanJsSerializer::class)

package moe.sdl.yabapi.data.login

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import moe.sdl.yabapi.data.GeneralCode
import moe.sdl.yabapi.data.GeneralCode.UNKNOWN
import moe.sdl.yabapi.serializer.BooleanJsSerializer

@Serializable
public data class LogOutResponse(
    @SerialName("code") public val code: GeneralCode = UNKNOWN,
    @SerialName("status") public val status: Boolean? = null,
    @SerialName("ts") public val timestamp: Long,
    @SerialName("message") public val message: String? = null,
    @SerialName("data") public val data: LogOutResponseData? = null,
)

@Serializable
public data class LogOutResponseData(
    @SerialName("redirectUrl") val redirectUrl: String,
)
