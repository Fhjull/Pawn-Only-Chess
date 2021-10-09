fun main() {
    // write your code here
    val size = readLine()!!.toInt()
    val list = MutableList(size) { readLine()!!.toInt() }
    val max = list.maxOrNull()!!
    println(list.indexOf(max))
}