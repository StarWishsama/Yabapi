package moe.sdl.yabapi.data

import kotlin.test.Test

internal class RgbColorTest {
    @Test
    fun toHex() {
        RgbColor(114, 114, 114).hex.also {
            println(it)
        }
    }

    @Test
    fun fromHex() {
        val random = 0..255
        repeat(255) {
            print("$it time: ")
            val r = random.random()
            val g = random.random()
            val b = random.random()
            val color = RgbColor(r, g, b).also(::println)
            val decoded = RgbColor.fromHex(color.hex).also(::println)
            if(decoded == color) print("OK") else print("Failed")
            println()
        }
    }

    @Test
    fun rgbaTest() {
        val random = 0..255
        repeat(255) {
            print("$it time: ")
            val r = random.random()
            val g = random.random()
            val b = random.random()
            val a = random.random()
            val color = RgbaColor(r, g, b, a).also(::println)
            val decoded = RgbaColor.fromHex(color.hex).also(::println)
            if(decoded == color) print("OK") else print("Failed")
            println()
        }
    }
}
