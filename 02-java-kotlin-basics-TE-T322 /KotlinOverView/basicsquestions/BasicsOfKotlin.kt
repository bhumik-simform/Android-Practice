import kotlin.random.Random
const val STORE_NAME = "ISKON GATHIYA"
fun main() {
    val products = listOf(
        PhysicalProduct("P100", 29.99, true),
        DigitalProduct("D200", 14.50, "https://download.link/item"),
        Subscription("S300", 9.99, 12),
        PhysicalProduct("P101", 100.0, false)
    )

    println("Welcome: $STORE_NAME")
    //for lambdas please specify what you want do in integer
    products
        .filter { it.price > 10.0 }
        .sortedBy { it.price }
        .map { "Product id: ${it.id} | Price: $${it.price}" }
        .forEach { println(it) }

    for (i in 0..<2) { // Open-ended range
        println("Applying batch ID to: ${products[i].id}")
    }


    print("------Sales Starts in------")
    for (i in 5 downTo 1 step 2) { // Reverse order with step
        print("$i... ")
    }

    print("Enter Discount Coupon: ")
    val userDiscount = readln()

    val cart = Cart(products)
    processCheckout(cart, userDiscount)

}

fun isDiscountEmpty(discount: String)= discount.isEmpty()
open class ProductKT(val id: Any,val price: Double)

class PhysicalProduct(id: Any, price: Double, val inStock: Boolean): ProductKT(id, price)
class DigitalProduct(id: Any, price: Double, val downloadLink: String): ProductKT(id, price)
class Subscription(id: Any, price: Double, val month: Int): ProductKT(id, price)

class Cart(val products: List<ProductKT>){ // I don`t know what to define......
    //What is this??
    operator fun iterator() : Iterator<ProductKT> {// what is operator
        return object: Iterator<ProductKT> {
            var currentIndex = 0
            override fun hasNext() = currentIndex < products.size
            override fun next() = products[currentIndex++]
        }
    }
}

fun processCheckout(cart: Cart, userDiscount: String)  {
    when(val code = userDiscount) {
        "DISCOUNT20", "SAVE20" -> println("Code matched: 20% off!")
        in setOf("VIP", "SUPERVIP") -> println("Code matched: VIP discount applied!") // in collection
        !in "A".."Z" -> println("Code format is completely invalid (not A-Z).") // !in range
        else -> println("No valid discount code applied.")
    }

    println("Processing Cart")
    for(item in cart) {
        when(item) {
            is PhysicalProduct -> println("Physical Item: ${item.id} | In Stock: ${item.inStock}")
            //Added conditions after checking the code
            is DigitalProduct if !item.downloadLink.isEmpty() && item.downloadLink.startsWith("https") ->
                println("Digital Item: ${item.id} with Download Link: ${item.downloadLink}")
            is Subscription -> println("Subscription: ${item.month} months")
            else -> print("Error: Unknow Product in Cart")
        }
    }
}

//Don`t get single line
fun paymentSimulation(method: Any): String? {
    var transactionId: String? = null
    try {
        print("------Payment Started------")
        val unsafeMethodId = method as Int
        transactionId = "TXN-${Random.nextInt(1000)}"
        println("Success with method ID: $unsafeMethodId")
    } catch (e: Exception) {
        transactionId = null
        println("Primary payment failed. Exception caught. Transaction length: ${transactionId?.length}")

        val stringMethod = method as? String

        if (stringMethod != null) {
            // Automatic smart cast to non-nullable String after null check
            println("Falling back to String-based method: ${stringMethod.uppercase()}")
            transactionId = "TXN-FALLBACK-999"
        }
    }


    return transactionId
}


