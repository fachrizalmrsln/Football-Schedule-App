package com.id.zul.submission5kade

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
class TeamDetailLocalResultInstrumentedTest {
    @Test
    fun useAppContext() {
        // ProviderContext of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.id.zul.submission5kade", appContext.packageName)
    }
}
