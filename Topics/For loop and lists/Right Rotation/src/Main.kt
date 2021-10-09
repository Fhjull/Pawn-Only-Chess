fun main() {
    // write your code here
    val size = readLine()!!.toInt()
    val list = MutableList(size) { readLine()!!.toInt() }
    repeat(readLine()!!.toInt().mod(size)) {
        val last = list[list.lastIndex]
        for (e in list.lastIndex downTo 1) {
            list[e] = list[e - 1]
        }
        list[0] = last
    }
    println(list.joinToString(" "))
}