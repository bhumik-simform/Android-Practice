/* 2. Write the function signature (just the first line, no curly braces or logic) for an
extension function on the Int class called isEven that takes no parameters and returns a Boolean.
 */
fun Int.isEven(): Boolean = this % 2 == 0

/* 3. Mini-Exercise (My Turn): Write the function signature for a
generic extension function on List<T> called secondElementOrNull. It should return a nullable type of T (T?).
 */

fun <T>List<T>.secondElementOrNull(): T? {
    return this.elementAtOrNull(1)
}

/* 4. Write the function signature for an extension function on a nullable String (String?) called isNullOrEmpty.
It should return a Boolean.
 */

fun String?.isNullOrEmpty(): Boolean {
    return this == null || this.isEmpty()
}

/* 5. A Car class has a member function startEngine().
You write an extension function Car.startEngine(keyType: String).
If you execute myCar.startEngine("SmartKey") in your code,
which one gets called: the member function or the extension function?
 */
class Car {
    fun startEngine() {
        print("Wroooooom Wroooooom")
    }
}

// If we remove key parameter from method and stop overloading than the member function will call by default
fun Car.startEngine(key: String) {
    print("Keys: $key")
    print("Meow Meow")
}

/* 6. Declare a variable named isAdult that holds an anonymous extension function for the Int class.
The function should take no parameters and return a Boolean (e.g., to check if this >= 18).
Don't write the implementation logic, just write the variable declaration and type annotation.
 */
val isAdult = fun Int.() = this >= 18

/*7. Write the property signature for an extension property on List<String> called middleItem.
It should return a nullable String (String?).
Do not write the get() block or the calculation logic.
 */

val List<String>.middleItem: String?
    get() {
        if (this.isEmpty()) return null
        return this[this.size / 2]
    }

class Server {
    companion object
}

/* 8. Mini-Exercise (My Turn): A Server class has an existing companion object.
Write the function signature for an extension function on this companion object called pingAll.
It should return a Boolean.
 */
fun Server.Companion.pingAll(): Boolean {
    return true
}

/* 9. Imagine a class named DataParser.
Inside it, you want an extension function for the Int class called toBinaryString() that returns a String.
Write just the class declaration line and the nested extension signature line.
 */

class DataParser {
    fun Int.toBinaryString():String {
        return "110001001"
    }
}

/*10. Write a base class called MathProcessor.
Inside it, write the signature for an open extension function on the Int class called calculate that returns an Int.
(No curly braces or logic needed).
 */
open class MathProcessor {
    open fun Int.calculate() = this
}
class Inc: MathProcessor() {
    override fun Int.calculate() = this+1
}