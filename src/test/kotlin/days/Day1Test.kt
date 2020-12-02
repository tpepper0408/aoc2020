package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Test

class Day1Test {

    private val dayOne = Day1()

    @Test
    fun testPartOne() {
        assertThat(dayOne.partOne(), `is`(equalTo(1006176)))
    }

    @Test
    fun testPartTwo() {
        val partTwo = dayOne.partTwo()
        assertThat(partTwo, `is`(equalTo(199132160)))
    }
}
