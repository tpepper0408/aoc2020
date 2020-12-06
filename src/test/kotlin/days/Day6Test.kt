package days

import org.junit.Test

import org.junit.Assert.*

class Day6Test {
    val day6 = Day6()

    @Test
    fun partOne() {
        assertEquals(6903, day6.partOne())
    }

    @Test
    fun partTwo() {
        assertEquals(3493, day6.partTwo())
    }
}