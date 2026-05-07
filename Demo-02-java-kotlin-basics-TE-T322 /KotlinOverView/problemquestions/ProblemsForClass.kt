package com.example.kotlin_practice.problemquestions

/*The Ride-Sharing App (Fare & State Management)
Concepts to use: class, Primary/Secondary constructors, init, val/var, Custom get()/set(), Backing fields (field), private, public.

User Story: A passenger books a ride. We need to track the base fare and a dynamic surge multiplier.

System Constraints:
When the ride is created, it must immediately log that a new ride started.
The surge multiplier can be updated,
but the system must absolutely prevent anyone from setting a negative multiplier or a multiplier less than 1.0 (if an invalid number is passed, it defaults to 1.0).
The raw base fare should be completely hidden from outside files to prevent manipulation.
Only the calculated total fare (base fare * surge) should be accessible to read.
 */

class Rider(val name: String,
            private val baseFare: Int,
            initMultiplier: Double
            ) {

    constructor(name: String, baseFare: Int): this(name, baseFare, 1.0)
    init { println("Rider $name is created.") }
    var surgeMultiplier: Double = initMultiplier
      set(value) {
          field = if(value < 1.0) 1.0 else value
      }

    val totalFare: Double
        get() = baseFare * surgeMultiplier
}

/*
Scenario: You are building a standard messaging app.
All messages share some core data, but different types of messages (text, image, audio) behave differently when displayed on the screen.
Your Requirements:

1. The Base Class: Create an abstract class called BaseMessage.
Its primary constructor should take a protected val senderId: String and a val timestamp: String.
Add an init block that simply prints "Preparing message from $senderId".
Declare an abstract fun displayMessage().
*/
abstract class BaseMessage(protected val senderId: String, val timestamp: String) {
    init {
        print("Preparing message from $senderId")
    }
    abstract fun displayMessage()
}

/* 2. The Subclass: Create a class called TextMessage that inherits from BaseMessage.
Its primary constructor should take senderId (String), timestamp (String), and a private val content: String.
(Remember to pass the required variables to the parent class!).
Override displayMessage() to print: "[$timestamp] Message: $content".
 */

/* 3. The Factory Method: Inside your TextMessage class, add a companion object.
    Write a factory function inside it called createQuickReply(senderId: String).
    This function should return a new TextMessage instance with the timestamp set to "Just now" and the content set to "On my way!".
 */
class TextMessage(senderId: String, timestamp: String, private val content: String): BaseMessage(senderId = senderId, timestamp = timestamp) {

    override fun displayMessage() {
        println("[$timestamp] Message: $content")
    }

    companion object {
        fun createQuickReplay(senderId: String) = TextMessage(senderId, "Just Now", "On My Way!")
    }
}
