fun helpingTheRobot(purchases: Map<String, Int>, addition: Map<String, Int>) : MutableMap<String, Int> {
    val resultMap = purchases.toMutableMap()
    for (key in addition.keys) {
        if (purchases.containsKey(key)) {
            resultMap[key] = purchases[key]!! + addition[key]!!
        } else {
            resultMap[key] = addition[key]!!
        }
    }
    return resultMap
}