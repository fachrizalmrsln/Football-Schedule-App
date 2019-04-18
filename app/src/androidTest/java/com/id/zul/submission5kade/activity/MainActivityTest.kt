package com.id.zul.submission5kade.activity

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.id.zul.submission5kade.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Rule
    @JvmField
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testSearchBehaviour() {
        onView(withId(R.id.appBar))
            .check(matches(isDisplayed()))

        delay()

        onView(withId(R.id.toolbar))
            .check(matches(isDisplayed()))

        delay()

        onView(withId(R.id.searchMenu))
            .check(matches(isDisplayed()))
            .perform(click())

        delay()

        onView(withId(android.support.v7.appcompat.R.id.search_src_text))
            .perform(typeText("arsenal"))
            .perform(pressImeActionButton())

        delay()

        onView(withId(R.id.recycler_search))
            .check(matches(isDisplayed()))

        delay()

        onView(withId(R.id.searchMenu))
            .check(matches(isDisplayed()))
            .perform(click())

        delay()

        onView(withId(android.support.v7.appcompat.R.id.search_src_text))
            .perform(typeText("real madrid"))
            .perform(pressImeActionButton())

        delay()

        onView(withId(R.id.recycler_search))
            .check(matches(isDisplayed()))

        delay()
    }

    private fun delay() {
        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }

}