package days

class Day7 : Day<Int>(7) {
    override fun partOne(): Int {
        val colourMap = HashMap<String, List<Pair<String, Int>>>()
        inputList.map {
            val (colour, childrenString) = it.split("bags contain")
                    .map { it.trim() }
            val children: List<Pair<String, Int>> = childrenString.split(',')
                    .map { it.trim() }
                    .map {
                        it.split(',')
                                .map {
                                    if (it.startsWith("no")) {
                                        return@map Pair("", 0)
                                    }
                                    val number = it[0].toString().toInt()
                                    val (colour) = Regex("([a-z ]*?) bag")
                                            .find(it)!!
                                            .destructured
                                    Pair(colour.trim(), number)
                                }
                    }.flatten()
            colourMap.put(colour, children)
        }

        val coloursThatContainShinyGold = checkForColour(colourMap, "shiny gold")
        return coloursThatContainShinyGold.size
    }

    fun checkForColour(colourMap: HashMap<String, List<Pair<String, Int>>>, colourToCheck: String) : HashSet<String> {
        val retval = HashSet<String>()
        for (childColour in colourMap.keys) {
            val children = colourMap.get(childColour)!!
            for (child in children) {
                if (child.first == colourToCheck) {
                    retval.add(childColour)
                    retval.addAll(checkForColour(colourMap, childColour))
                }
            }
        }
        return retval
    }

    override fun partTwo(): Int {
        val colourMap = HashMap<String, List<Pair<String, Int>>>()
        inputList.map {
            val (colour, childrenString) = it.split("bags contain")
                    .map { it.trim() }
            val children: List<Pair<String, Int>> = childrenString.split(',')
                    .map { it.trim() }
                    .map {
                        it.split(',')
                                .map {
                                    if (it.startsWith("no")) {
                                        return@map Pair("", 0)
                                    }
                                    val number = it[0].toString().toInt()
                                    val (colour) = Regex("([a-z ]*?) bag")
                                            .find(it)!!
                                            .destructured
                                    Pair(colour.trim(), number)
                                }
                    }.flatten()
            colourMap.put(colour, children)
        }
        return getNumberOfChildren(colourMap, "shiny gold")
    }

    private fun getNumberOfChildren(colourMap: HashMap<String, List<Pair<String, Int>>>, colourName: String): Int {
        var numberOfBags = 0
        val children = colourMap.get(colourName)!!
        for (child in children) {
            if (child.first == "") {
                continue
            }
            numberOfBags += child.second
            numberOfBags += child.second * getNumberOfChildren(colourMap, child.first)
        }
        return numberOfBags
    }
}