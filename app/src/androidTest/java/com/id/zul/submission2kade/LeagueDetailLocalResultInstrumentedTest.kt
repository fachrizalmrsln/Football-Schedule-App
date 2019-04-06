package com.id.zul.submission2kade

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class LeagueDetailLocalResultInstrumentedTest {
    @Test
    fun useAppContext() {
        // CoroutinesContext of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.id.zul.submission2kade", appContext.packageName)
    }
}
