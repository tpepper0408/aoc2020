package days

class Day8 : Day<Int>(8) {
    override fun partOne(): Int {
        return run(parseInstructions()).first
    }

    override fun partTwo(): Int {
        val instructions = parseInstructions()

        //if not do some swapping.
        val interestingIndexes = instructions.mapIndexed { index, instruction -> index to instruction }
                .filter { (_, instruction) -> instruction.first == "nop" || instruction.first == "jmp" }
                .map { (index, _) -> index }

        for (index in interestingIndexes) {
            val instructionArray = instructions.toTypedArray()
            instructionArray[index] = when(instructionArray[index].first) {
                "nop" -> "jmp" to instructionArray[index].second
                else -> "nop" to instructionArray[index].second
            }
            val (accumulated, completed) = run(instructionArray.toList())
            if (completed) return accumulated
        }
        return 0
    }

    private fun parseInstructions(): List<Pair<String, Int>> {
        return inputList.map {
            it.split(" ")[0] to it.split(" ")[1].toInt()
        }
    }

    private fun run(programme: List<Pair<String, Int>>): Pair<Int, Boolean> {
        val seen = HashSet<Int>()
        var index = 0
        var accumulated = 0

        while (index < programme.size) {
            if (seen.contains(index)) {
                return Pair(accumulated, false)
            } else {
                seen.add(index)
            }

            when (programme[index].first) {
                "nop" -> index++
                "acc" -> {
                    accumulated += programme[index].second
                    index++
                }
                "jmp" -> index += programme[index].second
            }
        }

        return Pair(accumulated, true)
    }
}