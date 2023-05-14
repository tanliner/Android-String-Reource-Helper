package com.lin.string.helper

import com.lin.string.helper.AndroidStringResourceHelper.getString
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test


@OptIn(ExperimentalCoroutinesApi::class)
internal class StringViewModelTest {

    @get:Rule
    val dispatcherRule = DispatcherRule()

    @Test
    fun should_show_formatted_string_when_pass_correct_args() = runTest {
        val arg1 = "located"
        val arg2 = "China"

        val viewModel = StringViewModel()

        advanceUntilIdle()

        val display = viewModel.display.value as TextForUI
        assertEquals(R.string.user_current_state, display.resId)
        assertEquals(arg1, display.args[0])
        assertEquals(arg2, display.args[1])
    }

    @Test
    fun should_show_formatted_string_when_pass_correct_args_via_helper() = runTest {

        val viewModel = StringViewModel()

        advanceUntilIdle()

        val display = viewModel.display.value as TextForUI
        assertEquals(R.string.user_current_state, display.resId)
        assertEquals("Now you have been located at China.", getString(R.string.user_current_state, *display.args))
    }
}
