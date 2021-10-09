fun addUser(userMap: Map<String, String>, login: String, password: String): MutableMap<String, String> {
    // write your code here
    val map = userMap.toMutableMap()
    if (userMap.containsKey(login)) {
        println("User with this login is already registered!")
    } else {
        map[login] = password
    }
    return map
}