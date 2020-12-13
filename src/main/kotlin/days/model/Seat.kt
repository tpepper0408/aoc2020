package days.model

data class Seat(val state: State, val switch: Boolean) {
    enum class State(val desc:String) {
        FREE("L"), OCCUPIED("#"), FLOOR("."), OUT("@")
    }
    fun desc() : String {
        return state.desc
    }
}