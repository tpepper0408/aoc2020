package days

import org.junit.Test

import org.junit.Assert.*

class Day3Test {
    val day3 = Day3()

    @Test
    fun partOne() {
        assertEquals(7, day3.partOne())
    }

    @Test
    fun partTwo() {
        assertEquals(336, day3.partTwo())
    }

    @Test
    fun findNumberOfTreesOneOne() {
        val parseSlope = day3.parseSlope()
        assertEquals(2, day3.traverseSlopeAndFindTrees(parseSlope, Pair(1,1)))
    }
    @Test
    fun findNumberOfTreesThreeOne() {
        val parseSlope = day3.parseSlope()
        assertEquals(7, day3.traverseSlopeAndFindTrees(parseSlope, Pair(1, 3)))
    }
    @Test
    fun findNumberOfTreesFiveOne() {
        val parseSlope = day3.parseSlope()
        assertEquals(3, day3.traverseSlopeAndFindTrees(parseSlope, Pair(1, 5)))
    }
    @Test
    fun findNumberOfTreesSevenOne() {
        val parseSlope = day3.parseSlope()
        assertEquals(4, day3.traverseSlopeAndFindTrees(parseSlope, Pair(1, 7)))
    }
    @Test
    fun findNumberOfTreesOneTwo() {
        val parseSlope = day3.parseSlope()
        assertEquals(2, day3.traverseSlopeAndFindTrees(parseSlope, Pair(2, 1)))
    }
}