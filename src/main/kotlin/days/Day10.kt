package days

import java.util.*


class Day10() : Day<Long>(10) {
    override fun partOne(): Long {
        var values = inputList.map {
            it.toInt()
        }.plus(0)
        values = values.sorted()

        var numberOf1Diffs = 0L
        var numberOf3Diffs = 0L
        var previousValue = -1
        for (value in values) {
            if (previousValue == -1) {
                previousValue = value
                continue
            }
            when (value - previousValue) {
                1 -> numberOf1Diffs++
                3 -> numberOf3Diffs++
                else -> {
                }
            }
            previousValue = value
        }
        numberOf3Diffs++
        println("1diffs $numberOf1Diffs: 3diffs $numberOf3Diffs")
        return numberOf1Diffs * numberOf3Diffs
    }

    override fun partTwo(): Long {
        var fullList = inputList.map {
            it.toInt()
        }.plus(0)
        fullList.plus(fullList.last() + 3)
        fullList = fullList.sorted()

        val gaps: MutableList<Int> = ArrayList()
        for (i in 1 until fullList.size) {
            val thisEntry = fullList[i]
            val previousEntry = fullList[i - 1]
            val difference = thisEntry - previousEntry
            gaps.add(difference)
        }

        val differenceString = StringBuilder()
        for (i in gaps.indices) {
            differenceString.append(gaps[i])
        }

        var diff = differenceString.toString()
        diff = diff.replace("111111", "E")
        diff = diff.replace("11111", "D")
        diff = diff.replace("1111", "C")
        diff = diff.replace("111", "B")
        diff = diff.replace("11", "A")

        var count: Long = 1
        for (element in diff) {
            when (element) {
                'A' -> count *= 2
                'B' -> count *= 4
                'C' -> count *= 7
                'D' -> count *= 13
                'E' -> count *= 24
            }
        }

        return count
    }
//    override fun partTwo(): Int {
//        var values = inputList.map {
//            it.toInt()
//        }.sorted()
//
//        val jumps = HashSet<Pair<Int,Int>>()
//        for (value in values) {
//            if (values.contains(value+1)) jumps.add(Pair(value, value+1))
//            if (values.contains(value+2)) jumps.add(Pair(value, value+2))
//            if (values.contains(value+3)) jumps.add(Pair(value, value+3))
//        }
//        val jumpList = jumps.sortedBy { it.first }
//        return jumpList.size
//    }
//
//    private fun successfulPath(values: List<Int>, successfulPaths: ArrayList<List<Int>>): ArrayList<Int> {
//        val currentPath = arrayListOf(0)
//        var previousValue = 0
//        var localIndex = 0
//        for (index in values.indices) {
//            val nextValue = values[index]
//            if (!validMove(nextValue, previousValue)) {
//                continue
//            }
//            if (alreadyMadeMove(successfulPaths, previousValue, nextValue, localIndex)) {
//                previousValue = nextValue
//                localIndex++
//                continue
//            }
//            previousValue = nextValue
//            currentPath.add(nextValue)
//        }
//        return currentPath
//    }
//
//    private fun alreadyMadeMove(successfulPaths: ArrayList<List<Int>>,
//                                previousValue: Int,
//                                nextValue: Int,
//                                index: Int): Boolean {
//        for (path in successfulPaths) {
//            val previousValueInPath = path[index]
//            if (path.size < index+1) {
//                return false
//            }
//            val nextValueInPath = path[index+1]
//            if (previousValue == previousValueInPath
//                    && nextValue == nextValueInPath) {
//                return true
//            }
//        }
//        return false
//    }
//
//    private fun validMove(value: Int, previousValue: Int): Boolean {
//        return when (value - previousValue) {
//            in 1..3 -> true
//            else -> false
//        }
//    }

}