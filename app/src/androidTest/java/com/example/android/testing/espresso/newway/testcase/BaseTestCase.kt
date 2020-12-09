package com.example.android.testing.espresso.newway.testcase

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.rules.activityScenarioRule
import com.example.android.testing.espresso.BasicSample.MainActivity
import org.junit.Rule

open class BaseTestCase {
    /**
     * Use [ActivityScenarioRule] to create and launch the activity under test before each test,
     * and close it after each test. This is a replacement for
     * [androidx.test.rule.ActivityTestRule].
     */
    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(getStartActivity(), getStartActivityOptions())

    open protected fun getStartActivity() = MainActivity::class.java
    open protected fun getStartActivityOptions(): Bundle? = null

    protected fun step(step: String) {
        Log.i("UITest:" + javaClass.simpleName, step)
    }
}