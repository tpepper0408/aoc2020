package days

import days.Day12.ShipFacing.*
import kotlin.Exception
import kotlin.math.abs

class Day12 : Day<Int>(12) {
    var debug = false

    enum class ShipFacing {
        EAST, NORTH, SOUTH, WEST
    }

    override fun partOne(): Int {
        var point = Pair(0, 0)
        var shipFacing = EAST
        inputList.forEach {
            val (directionString, numberStr) = Regex("([NSEWLRF])([0-9]+)").find(it)!!.destructured
            shipFacing = changeShipFacingPartOne(shipFacing, directionString, numberStr.toInt())
            point = moveShipPartOne(point, shipFacing, directionString, numberStr.toInt())
            if (debug) println("Here I am X: ${point.first} Y:${point.second}")
        }
        return abs(point.first) + abs(point.second)
    }

    override fun partTwo(): Int {
        var shipLocation = Pair(0, 0)
        var waypoint = Pair(1, 10)
        inputList.forEach {
            val (directionString, numberStr) = Regex("([NSEWLRF])([0-9]+)").find(it)!!.destructured
            when (directionString) {
                "F" -> {
                    shipLocation = moveTowardsWayPoint(shipLocation, waypoint, numberStr.toInt())
                }
                "N" -> {
                    waypoint = moveNorth(waypoint, numberStr.toInt())
                }
                "S" -> {
                    waypoint = moveSouth(waypoint, numberStr.toInt())
                }
                "E" -> {
                    waypoint = moveEast(waypoint, numberStr.toInt())
                }
                "W" -> {
                    waypoint = moveWest(waypoint, numberStr.toInt())
                }
                "L" -> {
                    waypoint = rotateWaypointLeft(waypoint, numberStr.toInt())
                }
                "R" -> {
                    waypoint = rotateWaypointRight(waypoint, numberStr.toInt())
                }
                else -> throw Exception("Unexpected direction $directionString")
            }
            if (debug) println("Here I am X: ${shipLocation.first} Y:${shipLocation.second}")
            if (debug) println("Waypoint X: ${waypoint.first} Y:${waypoint.second}")
        }

        return abs(shipLocation.first) + abs(shipLocation.second)
    }

    private fun rotateWaypointRight(waypoint: Pair<Int, Int>, degrees: Int): Pair<Int, Int> {
        return when (degrees) {
            90 -> Pair(-waypoint.second, waypoint.first)
            180 -> Pair(-waypoint.first, -waypoint.second)
            270 -> Pair(waypoint.second, -waypoint.first)
            else -> throw Exception("Unexpected rotation $degrees")
        }
    }

    private fun rotateWaypointLeft(waypoint: Pair<Int, Int>, degrees: Int): Pair<Int, Int> {
        return when (degrees) {
            90 -> Pair(waypoint.second, -waypoint.first)
            180 -> Pair(-waypoint.first, -waypoint.second)
            270 -> Pair(-waypoint.second, waypoint.first)
            else -> throw Exception("Unexpected rotation $degrees")
        }
    }

    private fun moveTowardsWayPoint(shipLocation: Pair<Int, Int>, waypoint: Pair<Int, Int>, times: Int): Pair<Int, Int> {
        return Pair(shipLocation.first + (waypoint.first * times), shipLocation.second + (waypoint.second * times))
    }

    private fun moveShipPartOne(point: Pair<Int, Int>, shipFacing: ShipFacing, directionString: String, distance: Int): Pair<Int, Int> {
        return when (directionString) {
            "E" -> moveEast(point, distance)
            "W" -> moveWest(point, distance)
            "N" -> moveNorth(point, distance)
            "S" -> moveSouth(point, distance)
            "L", "R" -> point
            "F" -> {
                when (shipFacing) {
                    EAST -> moveEast(point, distance)
                    WEST -> moveWest(point, distance)
                    NORTH -> moveNorth(point, distance)
                    SOUTH -> moveSouth(point, distance)
                }
            }
            else -> throw Exception("Unexpected direction")
        }
    }

    private fun moveSouth(point: Pair<Int, Int>, distance: Int) =
            Pair(point.first - distance, point.second)

    private fun moveNorth(point: Pair<Int, Int>, distance: Int) =
            Pair(point.first + distance, point.second)

    private fun moveWest(point: Pair<Int, Int>, distance: Int) =
            Pair(point.first, point.second - distance)

    private fun moveEast(point: Pair<Int, Int>, distance: Int) =
            Pair(point.first, point.second + distance)

    private fun changeShipFacingPartOne(currentFacing: ShipFacing, directionString: String, number: Int): ShipFacing {
        return when (directionString) {
            "L" -> {
                when (currentFacing) {
                    EAST -> {
                        when (number) {
                            90 -> NORTH
                            180 -> WEST
                            270 -> SOUTH
                            else -> throw Exception("Not a valid move")
                        }
                    }
                    NORTH -> {
                        when (number) {
                            90 -> WEST
                            180 -> SOUTH
                            270 -> EAST
                            else -> throw Exception("Not a valid move")
                        }
                    }
                    WEST -> {
                        when (number) {
                            90 -> SOUTH
                            180 -> EAST
                            270 -> NORTH
                            else -> throw Exception("Not a valid move")
                        }
                    }
                    SOUTH -> {
                        when (number) {
                            90 -> EAST
                            180 -> NORTH
                            270 -> WEST
                            else -> throw Exception("Not a valid move")
                        }
                    }
                }
            }
            "R" -> {
                when (currentFacing) {
                    EAST -> {
                        when (number) {
                            90 -> SOUTH
                            180 -> WEST
                            270 -> NORTH
                            else -> throw Exception("Not a valid move")
                        }
                    }
                    NORTH -> {
                        when (number) {
                            90 -> EAST
                            180 -> SOUTH
                            270 -> WEST
                            else -> throw Exception("Not a valid move")
                        }
                    }
                    WEST -> {
                        when (number) {
                            90 -> NORTH
                            180 -> EAST
                            270 -> SOUTH
                            else -> throw Exception("Not a valid move")
                        }
                    }
                    SOUTH -> {
                        when (number) {
                            90 -> WEST
                            180 -> NORTH
                            270 -> EAST
                            else -> throw Exception("Not a valid move")
                        }
                    }
                }
            }
            else -> currentFacing
        }
    }
}