package util

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.collection.IsIterableContainingInOrder.contains
import org.hamcrest.core.Is.`is`
import org.junit.Test

class UtilTests {

    @Test
    fun testReadInputAsString() {
        val testInputAsString = InputReader.getInputAsString(1)
        assertThat(testInputAsString, `is`("1721\n979\n366\n299\n675\n1456\n"))
    }

    @Test
    fun testReadInputAsList() {
        val testInputAsList = InputReader.getInputAsList(1)
        assertThat(testInputAsList, contains("1721", "979", "366", "299", "675", "1456"))
    }
}
