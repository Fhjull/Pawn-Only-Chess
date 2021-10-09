fun main() {
    // write your code here
    val list = MutableList(readLine()!!.toInt()) { readLine()!!.toInt() }
    val last = list.last()
    for (i in list.lastIndex downTo 1) {
        list[i] = list[i - 1]
    }
    list[0] = last
    println(list.joinToString(" "))
}