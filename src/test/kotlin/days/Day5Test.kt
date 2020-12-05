package days

import org.junit.Test

import org.junit.Assert.*

class Day5Test {
    val day5 = Day5()

    @Test
    fun partOne() {
        assertEquals(935, day5.partOne())
    }

    @Test
    fun parseLine() {
        assertEquals(357, day5.parseLine("FBFBBFFRLR"))
        assertEquals(567, day5.parseLine("BFFFBBFRRR"))
        assertEquals(119, day5.parseLine("FFFBBBFRRR"))
        assertEquals(820, day5.parseLine("BBFFBBFRLL"))
    }

    @Test
    fun partTwo() {
        assertEquals(743, day5.partTwo())
    }
}