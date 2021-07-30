fun main() {
    val adventure = listOf(Human("Frodo"),Mage("Gandolf"))
    for (man in adventure) man.attack()
    adventure[0].flag()
}

open class Human(val name: String) {
    var mana = true
    fun flag() {
        if (mana) println("\n$name has mana") else println("\n$name has no mana")
    }

    open fun attack() {
        println("$name use First Attack!")
        mana = !mana
    }
}

class Mage(name: String): Human(name) {
    override fun attack() = println("$name use Fireball!")
}