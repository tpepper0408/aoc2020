package days

import days.model.Seat
import days.model.Seat.State
import days.model.Seat.State.*

class Day11 : Day<Int>(11) {
    var debug = false


    override fun partOne(): Int {
        var seatMap = parseSeatMap()
        if (debug) printSeatMap(seatMap, "Initial state")
        var findChangesNeeded = ArrayList<ArrayList<Seat>>()
        var processedAllChanges = false
        do {
            findChangesNeeded = processChanges(seatMap, false)
            processedAllChanges = !checkForChangesNeeded(findChangesNeeded)
            seatMap = processChanges(findChangesNeeded, true)
            if (debug) printSeatMap(seatMap, "Processed")
        } while (!processedAllChanges)
        return countOccupiedSeats(seatMap)
    }

    private fun countOccupiedSeats(seatMap: java.util.ArrayList<java.util.ArrayList<Seat>>): Int {
        var number = 0
        for (seatRow in seatMap) {
            for (seat in seatRow) {
                if (seat.state == OCCUPIED) number++
            }
        }
        return number
    }

    private fun processChanges(seatMap: ArrayList<ArrayList<Seat>>, performChanges: Boolean): ArrayList<ArrayList<Seat>> {
        val retval = seatMap.toList()
        for (seatRowIndex in seatMap.indices) {
            val seatRow = seatMap[seatRowIndex]
            for (columnIndex in seatRow.indices) {
                when (seatRow[columnIndex].state) {
                    FLOOR -> retval[seatRowIndex][columnIndex] = Seat(FLOOR, false)
                    FREE -> {
                        if (seatRow[columnIndex].switch && performChanges) {
                            retval[seatRowIndex][columnIndex] = Seat(OCCUPIED, false)
                        } else {
                            val acceptableStates = arrayListOf<State>(FLOOR, FREE)
                            val checks = arrayListOf<Boolean>(
                                    acceptableStates.contains(getSeatState(seatMap, seatRowIndex - 1, columnIndex - 1)),
                                    acceptableStates.contains(getSeatState(seatMap, seatRowIndex - 1, columnIndex)),
                                    acceptableStates.contains(getSeatState(seatMap, seatRowIndex - 1, columnIndex + 1)),
                                    acceptableStates.contains(getSeatState(seatMap, seatRowIndex, columnIndex - 1)),
                                    acceptableStates.contains(getSeatState(seatMap, seatRowIndex, columnIndex + 1)),
                                    acceptableStates.contains(getSeatState(seatMap, seatRowIndex + 1, columnIndex - 1)),
                                    acceptableStates.contains(getSeatState(seatMap, seatRowIndex + 1, columnIndex)),
                                    acceptableStates.contains(getSeatState(seatMap, seatRowIndex + 1, columnIndex + 1)),
                            )
                            retval[seatRowIndex][columnIndex] = Seat(FREE, checks.reduce { acc, b -> acc && b })
                        }
                    }
                    OCCUPIED -> {
                        if (seatRow[columnIndex].switch && performChanges) {
                            retval[seatRowIndex][columnIndex] = Seat(FREE, false)
                        } else {
                            val acceptableStates = arrayListOf<State>(OCCUPIED)
                            val checks = arrayListOf<Boolean>(
                                    acceptableStates.contains(getSeatState(seatMap, seatRowIndex - 1, columnIndex - 1)),
                                    acceptableStates.contains(getSeatState(seatMap, seatRowIndex - 1, columnIndex)),
                                    acceptableStates.contains(getSeatState(seatMap, seatRowIndex - 1, columnIndex + 1)),
                                    acceptableStates.contains(getSeatState(seatMap, seatRowIndex, columnIndex - 1)),
                                    acceptableStates.contains(getSeatState(seatMap, seatRowIndex, columnIndex + 1)),
                                    acceptableStates.contains(getSeatState(seatMap, seatRowIndex + 1, columnIndex - 1)),
                                    acceptableStates.contains(getSeatState(seatMap, seatRowIndex + 1, columnIndex)),
                                    acceptableStates.contains(getSeatState(seatMap, seatRowIndex + 1, columnIndex + 1)),
                            )
                            retval[seatRowIndex][columnIndex] = Seat(OCCUPIED, checks.filter { it }.count() >= 4)
                        }
                    }
                }
            }
        }
        return ArrayList(retval)
    }

    private fun getSeatState(seatMap: ArrayList<ArrayList<Seat>>,
                               rowIndex: Int, columnIndex: Int): State {
        return try {
            seatMap[rowIndex][columnIndex].state
        } catch (exception: IndexOutOfBoundsException) {
            FLOOR
        }
    }

    private fun checkForChangesNeeded(seatMap: ArrayList<ArrayList<Seat>>): Boolean {
        for (seatRow in seatMap) {
            for (seat in seatRow) {
                if (seat.switch) return true
            }
        }
        return false
    }

    fun parseSeatMap(): ArrayList<ArrayList<Seat>> {
        var slopeMap = ArrayList<ArrayList<Seat>>()
        for (index in inputList.indices) {
            val line = inputList[index]
            var rowList = ArrayList<Seat>()
            for (lineIndex in line.toCharArray().indices) {
                rowList.add(
                        when (line[lineIndex]) {
                            '.' -> Seat(FLOOR, false)
                            'L' -> Seat(FREE, false)
                            else -> throw Exception("Unexpected rowContent")
                        })
            }
            slopeMap.add(rowList)
        }
        return slopeMap
    }

    private fun printSeatMap(slopeMap: ArrayList<ArrayList<Seat>>, message: String) {
        println(message)
        for (row in slopeMap) {
            for (seat in row) {
                print(seat.desc())
            }
            println()
        }
    }

    override fun partTwo(): Int {
        return 0
    }
}