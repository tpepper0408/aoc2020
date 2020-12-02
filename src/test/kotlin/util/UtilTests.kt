package util

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.collection.IsIterableContainingInOrder.contains
import org.hamcrest.core.Is.`is`
import org.junit.Test

class UtilTests {

    @Test
    fun testReadInputAsString() {
        val testInputAsString = InputReader.getInputAsString(26)
        assertThat(testInputAsString, `is`("1539\n1914\n1866\n1407\n1706\n1456\n"))
    }

    @Test
    fun testReadInputAsList() {
        val testInputAsList = InputReader.getInputAsList(26)
        assertThat(testInputAsList, contains("1539", "1914", "1866", "1407", "1706", "1456"))
    }
}
