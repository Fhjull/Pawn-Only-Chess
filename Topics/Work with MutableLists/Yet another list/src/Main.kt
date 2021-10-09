fun main() {
    print("a")
    val a: String by lazy {
        "c"
    }

    val b: String by lazy {
        a
    }
    print(a)
    print("b")
    print(b)
}