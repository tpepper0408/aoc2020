package days

import org.junit.Test

import org.junit.Assert.*

class Day10Test {

    val day10 = Day10()

    @Test
    fun partOne() {
        assertEquals(35, day10.partOne())
    }

    @Test
    fun partTwo() {
        assertEquals(8, day10.partTwo())
    }
}