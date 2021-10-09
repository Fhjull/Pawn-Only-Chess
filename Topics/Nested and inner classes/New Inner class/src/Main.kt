class Vehicle// create constructor
    (val name: String) {
    // add name
//    val name: String = "Dixi"

    // create inner class Body
    inner class Body
    //        val color = "red"
        (val color: String) {


        fun printColor() {
            println("The ${name} vehicle has a ${color} body.")
        }
    }
}