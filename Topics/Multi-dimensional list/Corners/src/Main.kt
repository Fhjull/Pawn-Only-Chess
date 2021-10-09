object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val number = 1357.05
        val number_log = Math.log10(number)
        val number_round = Math.round(number_log).toDouble()
        println(number_round)
    }
}