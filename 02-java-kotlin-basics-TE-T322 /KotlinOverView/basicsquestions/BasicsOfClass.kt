//1. Create a simple class called Product that has an empty body.
class ProductCls

/* 2. Declare a read-only variable named myProduct and
assign it a newly created instance of the Product class from the previous exercise.
 */
val productIns = ProductCls()

/* 3. Create a class called Customer with a primary constructor that
takes a read-only id (String) and a mutable email (String).
 */
class Costumer (val id: String,var email: String)

/*4. Create a class called Profile with a primary constructor taking a read-only username (String).
Add an initializer block that simply prints "Profile created for [username]".*/
class Profile(val userName: String) {
    init {
        print("User is Created for $userName ")
    }
}

/*5. Create a class User with a primary constructor taking a name (String) and an age (Int).
Then, write a secondary constructor that
only takes name and delegates to the primary constructor, defaulting the age to 0.
 */
class Users(val name:String,val age:Int) {
    constructor(name: String): this(name,0) {
        print("Calls Using Secondary Constructor.")
    }
}

/* 7. Create a class called MathUtils with a companion object.
Inside the companion object, write a function called add that takes two integers and returns their sum.
 */
class MathUtils {
    companion object {
        fun addInt(x: Int, y: Int) = x+y
    }
}

/*
9. Create a class Account with a private primary constructor that takes a balance (Double).
Add a companion object with a factory function called createEmptyAccount()
that returns a new Account instance with a balance of 0.0.*/

class Account private constructor(val balance: Double) {
    companion object {
        fun createEmptyAccount() = Account(0.0)
    }
}

/* 14. Create an open class Phone with an open fun ring() printing "Ring ring".
Create an interface Alarm with a fun ring() printing "Beep beep".
Create a SmartPhone class that inherits both and overrides ring() to call only the Alarm interface's version of ring().
 */

open class Phone {
    open fun ring() {
        print("Ring Ring")
    }
}

interface Alarm {
    fun ring() { print("Beep Beep") }
}

class SmartPhone: Phone(), Alarm {
    override fun ring() {
        super<Alarm>.ring()
    }
}

/* 15. Create a class called Student.
Inside the body (not the primary constructor),
declare a mutable property grade (String) initialized to "A" and
a read-only property schoolName (String) initialized to "Engineering University
 */

class Student {
    var grade = "A"
    val schoolName = "Engineering University"
}
/*16. Create a class called Square with a primary constructor taking val side: Int.
Inside the class, create a val perimeter: Int property with a custom getter that returns side * 4.*/

class Square(val side:Int) {
    val perimeter: Int
        get() = side*4
}

/*17.  Create a class Counter with a var count: Int initialized to 0.
Make the setter private. Add a public function called increment() that increases count by 1.
*/
class Counter {
    var count: Int = 0
        private set
    fun increment() {
        count+=1
    }
}

/*
18. Create a class Product with a var price: Double initialized to 0.0.
Write a custom setter for price that checks if the incoming value is greater than or equal to 0.0.
Only assign the value to field if that condition is true.
 */

class ProductCls1(initPrice: Double) {
    var price = initPrice
        set(value) {
            if (value>=0) field=value
        }
}

/*
19. Create a class called Playlist.
Inside, declare a private backing property _songs as a mutableListOf<String>().
Then, declare a public read-only property songs of type List<String> that returns _songs.
 */

class Playlist {
    private val _songs = mutableListOf<String>()
    val songs: List<String>
        get() = _songs
}

/* 20. Create a class called DatabaseConfig. Inside, declare a late init var called connectionString of type String.
Write a function initializeDB(url: String) that assigns the incoming url to the connectionString.
*/

class DatabaseConfig {
    lateinit var connectionString: String
    fun initializeDB(url: String) {
        connectionString = url
    }
}

/*
21.Create a class called Screen.
Inside it, declare a val named uiConfiguration of type String.
Use by lazy to initialize it with the string "Dark Mode Active".
 */
class Screen {
    val uiConfiguration: String by lazy {
        print("Initialize Configuration")
        "Dark Mode Active"
    }
}