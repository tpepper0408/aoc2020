package days

import org.junit.Test

import org.junit.Assert.*

class Day7Test {
    val day7 = Day7()

    @Test
    fun partOne() {
        assertEquals(121, day7.partOne())
    }

    @Test
    fun partTwo() {
        assertEquals(3805, day7.partTwo())
    }
}