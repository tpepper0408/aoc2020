package days

class Day1 : Day<Int>(1) {

    override fun partOne(): Int {
        val ints = inputList.map(String::toInt)
        for (i in ints.indices) {
            for (j in ints.indices) {
                if (i == j) continue
                if (ints[i] + ints[j] == 2020) {
                    return ints[i] * ints[j];
                }
            }
        }
        return 0
    }

    override fun partTwo(): Int {
        val ints = inputList.map(String::toInt)
        for (i in ints.indices) {
            for (j in ints.indices) {
                if (i == j) continue
                for (k in ints.indices) {
                    if (i == k || j == k) {
                        continue
                    }
                    if (ints[i] + ints[j] + ints[k] == 2020) {
                        return ints[i] * ints[j] * ints[k]
                    }
                }

            }
        }
        return 0
    }
}
