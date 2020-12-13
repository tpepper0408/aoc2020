package days

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class Day12Test {
    val day12 = Day12()

    @Before
    fun setUp() {
        day12.debug = true
    }

    @Test
    fun partOne() {
        assertEquals(25, day12.partOne())
    }

    @Test
    fun partTwo() {
        assertEquals(286, day12.partTwo())
    }
}