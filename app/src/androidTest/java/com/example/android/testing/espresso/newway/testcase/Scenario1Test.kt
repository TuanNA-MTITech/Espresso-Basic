/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.testing.espresso.newway.testcase

import android.app.Activity
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.pressBack
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import com.example.android.testing.espresso.newway.screens.DetailScreen
import com.example.android.testing.espresso.newway.screens.TopScreen
import org.junit.Test
import org.junit.runner.RunWith


/**
 * The kotlin equivalent to the ChangeTextBehaviorTest, that
 * showcases simple view matchers and actions like [ViewMatchers.withId],
 * [ViewActions.click] and [ViewActions.typeText], and ActivityScenarioRule
 *
 *
 * Note that there is no need to tell Espresso that a view is in a different [Activity].
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class Scenario1Test: BaseTestCase() {
    companion object {
        const val STRING_TO_BE_TYPED = "Hello World!"
    }

    @Test
    fun scenario1() {
        //check screen display
        step("1. Install app -> Open app -> Main screen")
        TopScreen.checkDisplay()

        // Type text and then press the button.
        step("2. Input text \"Hellow World!\" to EditText")
        TopScreen.inputText(STRING_TO_BE_TYPED)

        step("3. Press button \"Open Activity And Change Text\"")
        TopScreen.submit()
        DetailScreen.checkDisplay(STRING_TO_BE_TYPED)

        // This view is in a different Activity, no need to tell Espresso.
        step("4. Press Back-> Check main screen")
        Espresso.pressBack()
        // Check that the text was changed.
        TopScreen.checkTextDisplaying(STRING_TO_BE_TYPED)
    }
}