package moe.sdl.yabapi

import kotlinx.atomicfu.AtomicRef
import kotlinx.atomicfu.atomic
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.protobuf.ProtoBuf
import moe.sdl.yabapi.util.Logger
import kotlin.native.concurrent.SharedImmutable

@SharedImmutable
private val logger by lazy { Logger("Yabapi") }

public object Yabapi {
    public val defaultJson: AtomicRef<Json> = atomic(Json {
        prettyPrint = true
        isLenient = true
        coerceInputValues = true
    })

    @ExperimentalSerializationApi
    public val protoBuf: AtomicRef<ProtoBuf> = atomic(ProtoBuf)
}

internal inline fun <reified T> String.deserializeJson(): T {
    logger.debug { "Received Source String: $this" }
    return Yabapi.defaultJson.value.decodeFromString(this)
}
