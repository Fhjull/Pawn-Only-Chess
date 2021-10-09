fun removing(currentMap: MutableMap<Int, String>, value: String): MutableMap<Int, String> {
    // write your code here
    val map = currentMap.toMutableMap()
    val list = mutableListOf<Int>()
    for ((key, word) in currentMap) {
        if (word == value) {
            list.add(key)
        }
    }
    for (key in list) {
        map.remove(key)
    }
    return map
}