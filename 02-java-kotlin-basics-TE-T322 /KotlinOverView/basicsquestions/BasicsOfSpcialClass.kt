//Functional (SAM) Interface

/*1. Write a functional interface named LocationCallback.
It should contain a single abstract method called onLocationUpdated that takes two parameters: latitude (a Double) and longitude (a Double).
 */

fun interface LocationCallback {
    fun onLocationUpdated(latitude: Double, longitude: Double)
}

/* 2. Assuming you have a functional interface LocationCallback with a method onLocationUpdated(lat: Double, lng: Double),
write the code to create an instance of it using a SAM conversion (a lambda) that prints the latitude and longitude.
 */
val printLocation = LocationCallback { lat, lng ->
    print("Latitude: $lat")
    println("Longitude: $lng")
}

/*3. Imagine you have upgraded an old interface Logger to a fun interface Logger { fun log() }.
How would you pass it as a callable reference to a function defined as fun addLogger(loggerFactory: () -> Logger)?
 */

//Data Class
// 1. Create a data class called Product with two val properties in its primary constructor: id (an Int) and price (a Double).
//data class ProductDtCls(val id: Int,val price: Double)

/* 2. You have an instance val car = Car(brand = "Ford", color = "Black").
Write the code to create a new variable called paintedCar using copy(),
keeping the brand the same but changing the color to "Red".
*/

data class CarDtCls(val brand: String,val color: String) {
    var model: String? = null
}
val car = CarDtCls(brand = "Ford", color = "Black")
val car2 = car.copy(color = "Red")

/* 3. Given a data class Point(val x: Int, val y: Int) and an instance val center = Point(10, 20),
write the destructuring declaration to extract x and y into two new variables named xAxis and yAxis.
*/
data class Point(val x: Int, val y: Int)
val center = Point(10, 20)
//val (x,y) = center

val personInfo = Triple("Rakesh", 18, true)

//Sealed Class

/* 1. Create a sealed interface called NetworkState.
Then, write two classes that implement it: a data class called Connected (which takes a speed of type Int), and an object called Disconnected
 */
sealed class NetworkState
data class Connected(val networkSpeed: Int): NetworkState()
object Disconnected: NetworkState()

/* 2. Create a sealed class called Shape with a primary constructor that takes a val name: String.
Then, create a subclass called Circle that extends Shape, passing the hardcoded string "Circle" to the parent constructor.
 */
sealed class Shape(val name: String)
class Circle: Shape("Circle")

// 3. Declare a sealed class BaseEvent. Then declare an open class UIEvent that inherits from BaseEvent.
 sealed class BaseEvent
open class UIEvents: BaseEvent()

/*4. Assume you have a sealed class Theme with two objects: Light and Dark.
Write a when expression taking a theme: Theme variable that prints "Day" if it's Light and "Night" if it's Dark.
Do not include an else branch.
*/
sealed class Theme
object Light: Theme()
object Dark: Theme()

fun checkTheme(finalTheme: Theme) {
    when(finalTheme) {
        is Light -> println("The theme is Light.")
        is Dark -> println("The theme is Dark.")
    }
}

//5. Create a sealed class PaymentMethod. Add a data class Card(val number: String) and a data object Cash as its subclasses.
sealed class PaymentMethod
data class Card(val number: String): PaymentMethod()
data object Cash: PaymentMethod()

sealed class MyPayment: PaymentMethod()

//Nested and Inner Class
//1. Create an outer class called Bank and inside it, create a nested class called Currency with a property val code: String = "USD".
class Bank {
    class Currency(val code: String = "USD")
}
//2. Create a class called Car with a private val engineType = "V8". Inside it, create an inner class Engine with a function start() that prints out the engineType.
class CarOutCls(private val engineType:String = "V8") {
    inner class Engine {
        fun start() {
            print("Engine Type is: $engineType")
        }
    }
}
/* 3.Assume there is an interface TextWatcher with two methods: onTextChanged() and onTextCleared().
Write the syntax to create an anonymous instance of this interface using the object : TextWatcher expression. */
interface TextWatcher {
    fun onTextChanged()
    fun onTextCleared()
}

val textWatcher = object: TextWatcher {
    override fun onTextChanged() {
        println("Text is changed.")
    }

    override fun onTextCleared() {
        println("Text is cleared.")
    }
}

//Enums Class

/*1. Create an enum class named OrderStatus. It should have three constants: PENDING, SHIPPED, and DELIVERED.
Give the enum a constructor that takes a val code: Int, and assign 100, 200, and 300 to them, respectively.*/

enum class OrderStatus(val code: Int) {
    PENDING(100),
    SHIPPED(200),
    DELIVERED(300)
}

/*2. Create an enum class TrafficLight with constants RED and GREEN. Add an abstract fun nextLight(): TrafficLight.
Implement the anonymous class for RED so it returns GREEN, and for GREEN so it returns RED. (Don't forget the semicolon!)
 */
enum class TrafficLights {
    RED {
        override fun nextLight() = TrafficLights.GREEN
    },
    GREEN {
        override fun nextLight() = TrafficLights.RED
    };
    abstract fun nextLight(): TrafficLights
}

/*3. Assume there is an interface Printable { fun printName() }.
Write an enum class DocumentType with constants PDF and WORD that implements this interface.
Implement printName() generally for the whole enum (not anonymously per constant) so it prints "I am a document".
 */
interface Printable {
    fun printName()
}

enum class DocumentType: Printable {
    PDF,
    WORD;

    override fun printName() {
        println("I am a Document.")
    }
}

/* 4.Given an enum class Day { MONDAY, TUESDAY, WEDNESDAY }, Write the code to retrieve the list of all entries and store it in a variable called allDays.
Then write the code to get the ordinal of TUESDAY.
 */
enum class Day { MONDAY, TUESDAY, WEDNESDAY }
fun main() {
    val allDays = mutableListOf<Day>()
    for(day in Day.entries) {
        allDays.add(day)
    }
    println(allDays)
    println(Day.TUESDAY.ordinal)
}

