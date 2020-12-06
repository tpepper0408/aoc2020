package days

class Day6 : Day<Int>(6) {
    override fun partOne(): Int {
        return inputString
                .split("\n\n")
                .map {
                    it.replace("\n", "")
                            .toCharArray()
                            .toSet()
                            .count()
                }
                .reduce { acc, i -> acc + i }
    }

    override fun partTwo(): Int {
        return inputString
                .split("\n\n")
                .map {
                    val rows = it.split("\n")
                    var foundCharacters = rows[0].toCharArray().toSet()
                    for (otherRow in 1..rows.indices.last) {
                        foundCharacters = HashSet(foundCharacters.intersect(rows[otherRow].toCharArray().toSet()))
                    }
                    foundCharacters
                }
                .map { it.count() }
                .reduce { acc, i -> acc + i }
    }
}