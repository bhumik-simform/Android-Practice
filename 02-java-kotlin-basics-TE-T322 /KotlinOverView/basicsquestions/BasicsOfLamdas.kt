/*1. Write a higher-order function called processPayment.
It should accept an amount (Double) and a logger function.
 The logger function should take a Double as a parameter and return nothing (Unit).
 Inside processPayment, simply call the logger function and pass the amount to it.
 */
fun processPayment(amount: Double, logger: (Double)-> Unit) {
    logger(amount)
}

/*2. Declare a variable named formatTimestamp.
Assign it a function type that takes a Long (representing a Unix timestamp)
and returns a String (the readable date).*/
val formateTimeStamp: (Long)->String = {
    "09-03-2026"
}

/*
3. Create a variable addNumbers assigned to a lambda that takes two Ints and returns their sum.
Then, write a line of code to execute that function using the explicit .invoke() method.
*/
val addNumbers : (Int,Int) -> Int = {x,y -> x+y }
val result = addNumbers.invoke(10, 5)

/*4. Write a full lambda expression and assign it to a variable called multiply.
Declare the parameter types (Double, Double) explicitly inside the curly braces before the ->, and return their product.*/

val multiply = { x: Double, y: Double -> x*y }


/*5. The built-in Kotlin function repeat(times: Int, action: (Int) -> Unit) runs a block of code multiple times.
Call repeat to run 3 times, and use the trailing lambda syntax to print "Hello" inside the block.*/
//Implemented in main function

/*6. Declare a variable square of type (Int) -> Int.
Assign a lambda to it that uses the implicit it parameter to return the square of the number (number multiplied by itself).*/

val square : (Int) -> Int = { it*it }

/*7. Write a lambda and assign it to a variable getGreeting of type (String) -> String.
Inside the lambda, add a line that prints "Formatting name...", and
then on the very last line, write "Hello, $it!" so it implicitly returns the formatted string.
 */
val getGreeting : (String)-> String =  {
    print("Formatting the name...")
    "Hello, $it"
}

/*8. Write a lambda assigned to processMapEntry of type (String, Double) -> Unit. The parameters represent a key-value pair (like "USD", 1.0).
Use an underscore _ for the String key so it is ignored, and just print the Double value.*/
val processMapEntry: (String, Double) -> Unit = { _,value ->
    println(value)
}

/*9. Declare a variable divide.
Instead of using lambda {} syntax, assign an anonymous function to it using the fun keyword.
It should take two Double parameters and explicitly return a Double (their quotient).
*/

val divide = fun (a: Double, b: Double): Double {
    return a/b
}

/* 10.
Declare a var counter = 0. Then, declare a variable incrementCounter of type () -> Unit and assign a lambda to it.
Inside the lambda, modify the outer closure by adding 1 to counter.
*/

var counter = 0
val incrementCounter = {
    counter+=1
}

/* 11.
Assume you have a class User with a property var username = "". Declare a variable configureUser of type User.() -> Unit.
Inside the lambda, assign the string "AndroidDev" to username (do not use user.username, just use the implicit receiver property).*/

class User {
    var username = ""
}
val configureUser: User.() -> Unit = {
    username = "Android Dev"
}
/*12. The Scenario: You are building the checkout screen for a standard shopping app.
You need a flexible way to calculate the total price of specific items in a user's cart
(for example, calculating the total only for items that qualify for free shipping, or items above a certain price).
*/
/*
i.The Requirements:
The Setup:
Assume you have a simple class for your items:
*/
data class Product(val name: String, val price: Double)
/*ii.The Higher-Order Function: Write a function called processCart.
It must take two parameters: a List<Product> called cart, and a function called condition.
The condition must be a function type that takes a Product and returns a Boolean.
*/
fun processCart(products: List<Product>, condition: (Product)-> Boolean ) {
    var totalPrice = 0.0
    products.forEach {
        if (condition(it)) {
            println(it)
            totalPrice += it.price
        }
    }
    print(totalPrice)
}

/*iii. The Closure: Inside processCart, declare a var totalPrice = 0.0.
Loop through the cart (using a for loop or forEach).
If the product passes the condition function, add its price to totalPrice.
Finally, print the totalPrice.
*/

/* iv. The Execution: Write a main function where you:
Create a quick list of a few products.
Call processCart using the trailing lambda syntax.
Inside the lambda,
use the implicit it keyword to return true only if the product's price is greater than 50.0.
*/

fun main() {

    processPayment(60.0) { print("Amount is: $it") } // Usage of Exercise 1
    repeat(3) {
        println("Hello")
    } // Usage of Exercise 5
    val productList = listOf(
        Product("Milk",4.0),
        Product("Eggs",7.0),
        Product("Apple", 6.0),
        Product("Carrot",2.0),
        Product("Chicken",20.0)
    )
    processCart(productList) { it.price > 5.0 }
}