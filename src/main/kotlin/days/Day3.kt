package days

import java.lang.IndexOutOfBoundsException

class Day3 : Day<Long>(3) {
    override fun partOne(): Long {
        var slopeMap = parseSlope()
        printSlopeMap(slopeMap, "Initial Map")

        var position = Pair(1, 3)
        return traverseSlopeAndFindTrees(slopeMap, position)
    }

    fun parseSlope(): ArrayList<ArrayList<Boolean>> {
        var slopeMap = ArrayList<ArrayList<Boolean>>()
        for (index in inputList.indices) {
            val line = inputList[index]
            var rowList = ArrayList<Boolean>()
            for (lineIndex in line.toCharArray().indices) {
                rowList.add(line[lineIndex] == '#')
            }
            slopeMap.add(rowList)
        }
        return slopeMap
    }

    fun traverseSlopeAndFindTrees(slopeMap: ArrayList<ArrayList<Boolean>>, initialPosition: Pair<Int, Int>): Long {
        var position1 = Pair(initialPosition.first, initialPosition.second)
        var numberOfTrees = 0L;
        while (true) {
            if (slopeMap[position1.first][position1.second]) numberOfTrees++
            position1 = Pair(position1.first + initialPosition.first, position1.second + initialPosition.second)

            try {
                slopeMap[position1.first]
            } catch (e: IndexOutOfBoundsException) {
                break
            }
            try {
                slopeMap[position1.first][position1.second]
            } catch (e: IndexOutOfBoundsException) {
                val newPosition = position1.second - slopeMap[position1.first].size
                position1 = Pair(position1.first, newPosition)
            }
        }
        return numberOfTrees
    }

    fun printSlopeMap(slopeMap: ArrayList<ArrayList<Boolean>>, message: String) {
        println(message)
        for (row in slopeMap) {
            for (tree in row) {
                print(if (tree) "#" else ".")
            }
            println()
        }
    }

    override fun partTwo(): Long {
        var slopeMap = parseSlope()
        printSlopeMap(slopeMap, "Initial Map")

        var treesFound = 1L
        for (position in
        arrayOf(
                Pair(1, 1),
                Pair(1, 3),
                Pair(1, 5),
                Pair(1, 7),
                Pair(2, 1))
        ) {
            val traverseSlopeAndFindTrees = traverseSlopeAndFindTrees(slopeMap, position)
            treesFound *= traverseSlopeAndFindTrees
        }
        return treesFound
    }
}