package days

import org.junit.Test

import org.junit.Assert.*

class Day8Test {
    val day8 = Day8()

    @Test
    fun partOne() {
        assertEquals(1137, day8.partOne())
    }

    @Test
    fun partTwo() {
        assertEquals(1125, day8.partTwo())
    }
}