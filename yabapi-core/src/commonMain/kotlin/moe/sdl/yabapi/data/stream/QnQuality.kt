package moe.sdl.yabapi.data.stream

import kotlinx.serialization.Serializable
import moe.sdl.yabapi.serializer.data.stream.QnQualitySerializer
import moe.sdl.yabapi.util.Logger
import kotlin.native.concurrent.SharedImmutable

@SharedImmutable
private val logger by lazy { Logger("QnQuality") }

@Serializable(QnQualitySerializer::class)
public enum class QnQuality(public val code: Int) {
    UNKNOWN(-1),
    V240P(6),
    V360P(16),
    V480P(32),
    V720P(64),
    V720P60F(74),
    V1080P(80),
    V1080Plus(112),
    V1080P60(116),
    V4K(120),
    HDR(125),
    DOLBY(126),
    V8K(127),

    // audio
    A64K(30216),
    A132K(30232),
    A192K(30280);

    public companion object {
        public fun fromCode(code: Int): QnQuality = values().firstOrNull { it.code == code }
            ?: run {
                logger.warn { "Unknown QnQuality code $code" }
                UNKNOWN
            }
    }
}
