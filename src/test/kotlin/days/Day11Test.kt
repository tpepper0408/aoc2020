package days

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class Day11Test {

    val day11 = Day11()

    @Before
    fun setUp() {
        day11.debug = true
    }

    @Test
    fun partOne() {
        assertEquals(37, day11.partOne())
    }

    @Test
    fun partTwo() {
        assertEquals(26, day11.partOne())
    }
}