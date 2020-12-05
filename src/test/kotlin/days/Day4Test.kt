package days

import org.junit.Test

import org.junit.Assert.*

class Day4Test {
    val day4 = Day4()

    @Test
    fun partOne() {
        assertEquals(206, day4.partOne())
    }

    @Test
    fun partTwo() {
        assertEquals(123, day4.partTwo())
    }
}