package days

class Day2 : Day<Int>(2) {
    override fun partOne(): Int {
        return inputList.filter {
            checkPassword(it, ::checkPasswordViability)
        }.count()
    }

    override fun partTwo(): Int {
        return inputList.filter {
            checkPassword(it, ::checkPasswordViabilityWithIndexes)
        }.count()
    }

    private fun checkPassword(it: String, checker: (String, Char, Int, Int) -> Boolean): Boolean {
        val foundPattern = Regex("^([0-9]+)-([0-9]+) ([a-z]): ([a-z]+)\$").find(it)!!
        val (startRange, endRange, letterToCheck, passwordToCheck) = foundPattern.destructured
        return checker(passwordToCheck, letterToCheck.toCharArray()[0], startRange.toInt(), endRange.toInt())
    }

    private fun checkPasswordViability(passwordToCheck: String, letterToCheck: Char, startRange: Int, endRange: Int): Boolean {
        var numberOfCorrectLetters = 0
        for (c in passwordToCheck) {
            if (c == letterToCheck) {
                numberOfCorrectLetters++
            }
        }
        return numberOfCorrectLetters in (startRange) until endRange + 1
    }

    private fun checkPasswordViabilityWithIndexes(passwordToCheck: String, letterToCheck: Char, startRange: Int, endRange: Int): Boolean {
        val firstInRange = passwordToCheck[startRange - 1] == letterToCheck
        val secondInRange = passwordToCheck[endRange - 1] == letterToCheck
        return firstInRange.xor(secondInRange)
    }
}