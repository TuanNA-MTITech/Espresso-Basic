package com.example.android.testing.espresso.newway.screens

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.example.android.testing.espresso.BasicSample.R

object DetailScreen {
    private fun viTextView() = Espresso.onView(withId(R.id.show_text_view))

    /**
     * check screen displaying with text
     */
    fun checkDisplay(text: String) {
        viTextView().check(matches(withText(text)))
    }
}