fun main() {
    // write your code here
    val list = List(readLine()!!.toInt()) { readLine()!!.toInt() }
    println(
        if (list.contains(readLine()!!.toInt())) "YES" else "NO"
    )
}