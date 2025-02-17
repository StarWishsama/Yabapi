package moe.sdl.yabapi.api

import moe.sdl.yabapi.client
import moe.sdl.yabapi.enums.history.HistoryType
import moe.sdl.yabapi.initTest
import moe.sdl.yabapi.runTest
import moe.sdl.yabapi.util.encoding.avInt
import kotlin.test.Test

internal class HistoryApiTest {
    init {
        initTest()
    }

    @Test
    fun getHistoryTest() = runTest {
        with(client) {
            val viewAt = getHistory().data!!.list.last().viewAt
            getHistory(fromTime = viewAt)
        }
    }

    @Test
    fun deleteHistoryTest() = runTest {
        client.deleteHistory("BV1Qm4y1D7Rd".avInt, HistoryType.VIDEO)
    }

    @Test
    fun setStopHistoryTest() = runTest {
        client.setStopHistory(true)
    }

    @Test
    fun getHistoryStatusTest() = runTest {
        client.getHistoryStatus()
    }

    @Test
    fun clearHistoryTest() = runTest {
        client.clearHistory()
    }

    @Test
    fun getLaterWatchTest() = runTest {
        client.getLaterWatch()
    }

    @Test
    fun addLaterWatchTest() = runTest {
        client.addLaterWatch(170001)
        client.addLaterWatch("BV1au411m76q")
    }

    @Test
    fun addChannelToLaterWatchTest() = runTest {
        client.addChannelToLaterWatch(72, 63231)
    }

    @Test
    fun deleteLaterWatchTest() = runTest {
        client.deleteLaterWatch(170001)
        client.deleteViewedLaterWatch()
        client.deleteLaterWatch("BV1Gs411C7Pt")
    }

    @Test
    fun clearLaterWatchTest() = runTest {
        client.clearLaterWatch()
    }
}
