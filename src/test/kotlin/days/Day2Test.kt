package days

import org.hamcrest.MatcherAssert
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is
import org.hamcrest.core.IsEqual
import org.junit.Test

import org.junit.Assert.*

class Day2Test {
    private val dayTwo = Day2()

    @Test
    fun partOne() {
        assertThat(dayTwo.partOne(), Is.`is`(IsEqual.equalTo(477)))
    }

    @Test
    fun partTwo() {
        assertThat(dayTwo.partTwo(), Is.`is`(IsEqual.equalTo(686)))
    }
}