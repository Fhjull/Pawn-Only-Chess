fun main() {
    val studentsMarks = mutableMapOf<String, Int>()
    while (true) {
        val name = readLine()!!
        if (name == "stop") break
        val age = readLine()!!.toInt()
        if (!studentsMarks.containsKey(name)) {
            studentsMarks[name] = age
        }
    }
    println(studentsMarks)
}