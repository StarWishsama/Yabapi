package sdl.moe.yabapi.serializer.data.login

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import sdl.moe.yabapi.data.login.QueryCaptchaResponseCode
import sdl.moe.yabapi.util.getEnumFieldAnnotation

internal object QueryCaptchaResponseCodeSerializer : KSerializer<QueryCaptchaResponseCode> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor(this.javaClass.simpleName, PrimitiveKind.INT)

    override fun serialize(encoder: Encoder, value: QueryCaptchaResponseCode) = encoder.encodeString(value.name)

    override fun deserialize(decoder: Decoder): QueryCaptchaResponseCode {
        return decoder.decodeInt().let { value ->
            QueryCaptchaResponseCode.values()
                .firstOrNull { it.getEnumFieldAnnotation<SerialName>()?.value?.toInt() == value }
                ?: run { QueryCaptchaResponseCode.UNKNOWN }
        }
    }
}
