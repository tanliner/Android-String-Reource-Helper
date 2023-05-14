package com.lin.string.helper

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.rules.ExternalResource

@OptIn(ExperimentalCoroutinesApi::class)
class DispatcherRule : ExternalResource() {
    private val dispatcher = TestCoroutineDispatcher()


    override fun before() {
        Dispatchers.setMain(dispatcher)
    }

    override fun after() {
        Dispatchers.resetMain()
        dispatcher.cleanupTestCoroutines()
    }
}
