package days

class Day9() : Day<Long>(9) {
    var preambleSize = 25
    var badNumber = 85848519L

    override fun partOne(): Long {
        var rangeToCheck = 0 until preambleSize
        val values = inputList.map { it.toLong() }
        for (index in values.indices) {
            if (index < preambleSize) {
                continue
            }
            var foundSum = false
            for (i in rangeToCheck) {
                for (j in rangeToCheck) {
                    if (i == j) continue
                    if (values[i] + values[j] == values[index]) {
                        foundSum = true
                    }
                }
            }
            if (!foundSum) return values[index]
            rangeToCheck = rangeToCheck.first + 1..rangeToCheck.last + 1
        }
        return 0
    }

    override fun partTwo(): Long {
        val values = inputList.map { it.toLong() }
        var beginning = 0
        var foundRange: IntRange? = null
        while (foundRange == null) {
            var sum = 0L
            for (index in beginning..values.lastIndex) {
                sum += values[index]
                if (sum == badNumber) {
                    foundRange = beginning until index
                } else if (sum > badNumber) {
                    break
                }
            }
            beginning++
            if (beginning == values.lastIndex) {
                break
            }
        }
        if (foundRange == null) {
            return 0
        }
        val slice = values.slice(foundRange)
        return slice.minByOrNull { it }!! + slice.maxByOrNull { it }!!
    }
}