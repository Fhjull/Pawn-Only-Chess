data class Vehicle(val name: String) {

    // create constructor

    inner class Engine(val horsePower: Int) {
        // add horsePower

        // create constructor

        fun start() {
            println("RRRrrrrrrr....")
        }

        // create function printHorsePower()
        fun printHorsePower() {
            println("The $name vehicle has $horsePower horsepower.")
        }
    }
}
