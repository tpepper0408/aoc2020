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
        val indexOfHyphen = it.indexOf('-')
        val indexOfFirstSpace = it.indexOf(' ', indexOfHyphen)
        val indexOfPassword = it.indexOf(':') + 1

        val startRange = it.substring(0, indexOfHyphen).toInt()
        val endRange = it.substring(indexOfHyphen + 1, indexOfFirstSpace).toInt()
        val letterToCheck = it[indexOfFirstSpace + 1]
        val passwordToCheck = it.substring(indexOfPassword)
        return checker(passwordToCheck, letterToCheck, startRange, endRange)
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
        val firstInRange = passwordToCheck[startRange] == letterToCheck
        val secondInRange = passwordToCheck[endRange] == letterToCheck
        if (firstInRange && !secondInRange) {
            return true
        }
        if (secondInRange && !firstInRange) {
            return true
        }
        return false
    }
}