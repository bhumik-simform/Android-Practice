package com.example.kotlin_practice.problemquestions

/*
The Real-World Scenario: E-Commerce Checkout
Imagine you are building the checkout screen for a standard e-commerce app. You are dealing with messy user input (promo codes), a list of items in the cart, and a need for a safe fallback mechanism.
Write the code for the following three requirements. I have provided the setup classes for you to use.
The data class you are working with:
*/
data class CartItem(val name: String, val price: Double)
/*
Task 1: Nullable Receiver (The Promo Code Sanitizer)
Users type in promo codes, but the API might return null, or the user might just leave it blank.
Requirement: Write an extension function on String? called sanitizePromoCode that returns a non-nullable String.
Logic: If the string is null or entirely blank, return the default string "NO_CODE".
If it has text, return the text with no leading/trailing spaces  and converted to uppercase.
*/
fun String?.sanitizePromoCode(): String {
    if(this.isNullOrBlank()) return "NO_CODE"
    return this.trim().uppercase()
}
/* Task 2: Extension Property (The Cart Total Calculator)
Instead of writing a bulky function to calculate the cart total every time the UI updates,
an extension property makes the code read like English (val total = myCart.cartTotal).
Requirement: Write an extension property on List<CartItem> called cartTotal that returns a Double.
Logic: In the get() block, calculate the total sum of all the prices in the list.
(Hint: You can use the built-in Kotlin function this.sumOf { it.price } to make this a quick one-liner!)
*/
val  List<CartItem>.cartTotal: Double
    get() = this.sumOf { it.price }

/* Task 3: Generic Extension Function (The Safe Fallback)
Sometimes the app tries to grab an item from a list (like the second item to show as a "Recommended" preview),
but the list might be too short, which would cause a crash.
Requirement: Write a generic extension function on List<T> called getSecondOrFallback.
It must take one parameter named fallback of type T, and it must return a single item of type T.
Logic: If the list has a second item (index 1), return it.
If the list is too small to have a second item, return the fallback item that was passed in.
 */

fun <T> List<T>.getSecondOrFallback(fallback: T): T {
   return this.elementAtOrNull(1) ?: fallback
}