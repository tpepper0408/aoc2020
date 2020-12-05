package days

class Day5 : Day<Int>(5) {
    override fun partOne(): Int {
        return inputList.map { parseLine(it) }
                .maxByOrNull{it} ?: 0
    }

    fun parseLine(row: String) : Int {
        val rowCode = row.substring(0, 7)
                .map {
                    when (it) {
                        'F' -> 0
                        'B' -> 1
                        else -> throw Exception()
                    }
                }.joinToString("")
        val columnCode = row.substring(7)
                .map {
                    when(it) {
                        'L' -> 0
                        'R' -> 1
                        else -> throw Exception()
                    }
                }.joinToString("")
        val rowNumber = Integer.parseInt(rowCode, 2)
        val columnNumber = Integer.parseInt(columnCode, 2)
        return (rowNumber * 8) + columnNumber
    }

    override fun partTwo(): Int {
        val seats = inputList.map { parseLine(it) }
                .sorted()
        for (i in seats.indices) {
            val seatToCheck = seats[i]
            if (seats[i+1] != seatToCheck+1) {
                return seatToCheck+1
            }
        }
        return 0
    }
}