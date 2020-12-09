package com.example.android.testing.espresso.newway.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withHint
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.example.android.testing.espresso.BasicSample.R

object TopScreen {
    private fun viInput() = onView(ViewMatchers.withId(R.id.editTextUserInput))
    private fun viChangeText() = onView(ViewMatchers.withId(R.id.changeTextBt))
    private fun viTextWillChange() = onView(ViewMatchers.withId(R.id.textToBeChanged))
    private fun viChangeNewActivity() = onView(ViewMatchers.withId(R.id.activityChangeTextBtn))

    /**
     * general UI checking follow Design
     */
    fun checkDisplay() {
        viInput().check(matches(withHint("type something…")))
    }

    /**
     * input the text and submit the text
     */
    fun inputText(text: String) {
        viInput().perform(typeText(text), closeSoftKeyboard())
        viChangeText().perform(click())
        checkTextDisplaying(text)
    }

    /**
     * check the text is displaying
     */
    fun checkTextDisplaying(text: String) {
        viTextWillChange().check(matches(withText(text)))
        viInput().check(matches(withText(text)))
    }

    /**
     * do pressing on button submit
     */
    fun submit() {
        viChangeNewActivity().perform(click())
    }
}