package common

fun getRandomList(count: Int = 100): MutableList<Double> {
    val result = mutableListOf<Double>()
    var index: Int = 0
    while (index < count) {
        val random: Double = Math.random()
        result.add(random)
        index.inc()
    }
    return result
}