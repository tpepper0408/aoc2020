package days

class Day13: Day<Long>(13) {
    override fun partOne(): Long {
        val firstTimePossible = inputList[0].toLong()
        val busTimes = inputList[1].split(",").filter { it != "x" }.map { it.toLong() }

        var foundTime = firstTimePossible
        var busId = 0L
        while (true) {
            for (busTime in busTimes) {
                if (foundTime % busTime == 0L) {
                    busId = busTime
                    break;
                }
            }
            if (busId != 0L) {
                break
            }
            foundTime++
        }
        return (foundTime - firstTimePossible) * busId
    }

    override fun partTwo(): Long {
        val busSchedule = inputList[1]
                .split(",")

        val offSetToFactor = mutableMapOf<Long, Long>()
        for (busIndex in busSchedule.indices) {
            if (busSchedule[busIndex] == "x") {
                continue
            }
            offSetToFactor[busIndex.toLong()] = busSchedule[busIndex].toLong()
        }
        val offsets = offSetToFactor.keys.reversed()
        var value = inputList[0].toLong()
        var increment = 1L
        for (offset in offsets) {
            while (true) {
                if ((value + offset) % offSetToFactor[offset] !! == 0L) {
                    increment *= offSetToFactor[offset] !!
                    break
                }
                else value += increment
            }
            println("Found candidate $value using increment $increment")
        }
        return value
    }
}