fun main() {
    // write your code here
    val list = MutableList(readLine()!!.toInt()) { readLine()!!.toInt() }.joinToString("")
    val pm = readLine()!!.split(" ").map { it.toInt() }.joinToString("")
    println(if (list.contains(pm) || list.contains(pm.reversed())) "NO" else "YES")
}