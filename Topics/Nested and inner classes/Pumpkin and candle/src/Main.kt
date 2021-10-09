class Pumpkin(val type: String, val isForHalloween: Boolean) {

    // create function addCandle()
    fun addCandle() {
        if (isForHalloween) {
            this.Candle().burning()
        } else {
            println("We don't need a candle.")
        }
    }

    inner class Candle {
        fun burning() {
            println("The candle is burning inside this spooky $type pumpkin! Boooooo!")
        }
    }
}