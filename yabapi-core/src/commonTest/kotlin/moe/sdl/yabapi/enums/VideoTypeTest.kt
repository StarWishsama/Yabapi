package moe.sdl.yabapi.enums

import com.soywiz.korio.lang.assert
import moe.sdl.yabapi.enums.video.Douga
import moe.sdl.yabapi.enums.video.VideoType
import kotlin.test.Test

internal class VideoTypeTest {
    @Test
    fun getAllTypesTest() {
        VideoType.getAllTypes()
        val fromCode = VideoType.fromCode("douga")
        val fromTid = VideoType.fromTid(1)
        assert(fromCode === Douga)
        assert(fromTid === Douga)
    }

    @Test
    fun getAllRouteUrlTest() {
        VideoType.getAllUrl().forEach(::println)
    }
}
