fun main() {
    // write your code here
    val number = readLine()!!.toInt()
    val income = MutableList(number) { readLine()!!.toInt() }
    val taxes = MutableList(number) { readLine()!!.toInt() }
    val result = List(number) { (income[it] * taxes[it]).toDouble() / 100 }
    val res = result.indexOf(result.maxOrNull()) + 1
    println(res)
}