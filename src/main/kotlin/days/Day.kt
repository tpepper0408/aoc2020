package days

import util.InputReader

abstract class Day<T>(dayNumber: Int) {

    // lazy delegate ensures the property gets computed only on first access
    protected val inputList: List<String> by lazy { InputReader.getInputAsList(dayNumber) }

    abstract fun partOne(): T

    abstract fun partTwo(): T
}
