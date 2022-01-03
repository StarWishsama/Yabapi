// © Copyright 2022 Colerar and repository contributors
// Use of this source code is governed by the MIT license that can be found via link below:
// https://github.com/SDLMoe/Yabapi/blob/master/LICENSE

package sdl.moe.yabapi.serializer.data.stream

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind.INT
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import sdl.moe.yabapi.data.stream.VideoFnvalFormat

public object FnvalFormatSerializer : KSerializer<VideoFnvalFormat> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("VideoFnvalFormatSerializer", INT)
    override fun serialize(encoder: Encoder, value: VideoFnvalFormat): Unit = encoder.encodeInt(value.toBinary())
    override fun deserialize(decoder: Decoder): VideoFnvalFormat = VideoFnvalFormat.fromBinary(decoder.decodeInt())
}
