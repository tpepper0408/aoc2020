package days

import org.junit.Test

import org.junit.Assert.*

class Day13Test {
    private val day13 = Day13()

    @Test
    fun partOne() {
        assertEquals(295, day13.partOne())
    }

    @Test
    fun partTwo() {
        assertEquals(1068781, day13.partTwo())
    }
}