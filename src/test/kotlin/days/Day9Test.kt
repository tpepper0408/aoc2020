package days

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class Day9Test {
    val day9 = Day9()

    @Before
    fun setUp() {
        day9.preambleSize = 5
        day9.badNumber = 127L
    }

    @Test
    fun partOne() {
        assertEquals(127, day9.partOne())
    }

    @Test
    fun partTwo() {
        assertEquals(62, day9.partTwo())
    }
}