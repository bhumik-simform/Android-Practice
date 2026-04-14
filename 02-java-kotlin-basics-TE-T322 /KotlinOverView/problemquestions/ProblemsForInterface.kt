package com.example.kotlin_practice.problemquestions

/*
Concepts to use: interface, default interface methods, overriding conflicts, open, override, super, protected.

User Story: Users can listen to Audio or watch Video. Sometimes they download them.

System Constraints:
We have a strict contract for all media: they must have a "play" action.
We have another contract for "Downloadable" items, which has a default behavior for downloading.
Both contracts happen to have a method named showDetails().
You need a base media structure that holds a DRM (Digital Rights Management) key.
This key is highly sensitive—it must only be visible to the base structure and its direct specific media types (like Podcast or Movie), nowhere else.
When a Movie plays, it must do what the base media does, but also add its own specific video-rendering logic.
*/

interface Playable { //These are behaviour of Media There for
    fun showDetails() { print("This is playable media")}
    fun play()
}

interface Downloadable { //These are behaviour of Media There for
    fun showDetails() {print("This is downloadable media")}
    fun downloading()
}

//I use interface while providing implementation for one method because i need to use multiple inheritance
open class MediaItem(var name: String) {
    protected val dRMKey : String = "secret DRM key"
}
class Video(name: String): MediaItem(name), Playable, Downloadable {
    override fun play() {
        println("Playing $name")
    }

    override fun downloading() {
        print("Downloading $name")
    }


    override  fun showDetails() {
        super<Playable>.showDetails()
        super<Downloadable>.showDetails()
    }
}


/*Scenario: You are building the checkout screen for a standard food delivery app.
You need to handle different types of payments interchangeably without the main app caring about the specific details of each method.

Your Requirements:
The Interface: Create an interface called PaymentMethod.
It must require a read-only property called providerName (String).
It must require a function called processPayment(amount: Double) with no body.
*/
interface PaymentMethod {
    val providerName: String
    fun processPayment(amount: Double)
}

/*
Implementation 1: Create a class called CreditCard that implements PaymentMethod.
Its primary constructor should take a private val cardNumber: String.
Override providerName and assign it something like "Visa".
Override processPayment() to print: "Charging $[amount] to card ending in ${cardNumber.takeLast(4)} via $providerName".
*/
class CreditCard(private val cardNumber: String, override val providerName: String): PaymentMethod {
    override fun processPayment(amount: Double) {
        print("Charging $amount to card ending in ${cardNumber.takeLast(4)} via $providerName.")
    }
}
/* Implementation 2: Create a class called DigitalWallet that implements PaymentMethod.
Its primary constructor should take an internal val accountEmail: String
Override providerName and assign it "PayPal" (or similar).
Override processPayment() to print: "Processing $[amount] from wallet $accountEmail".
 */
class DigitalWallet(internal val accountEmail: String, override val providerName: String = "Paypal"): PaymentMethod {
    override fun processPayment(amount: Double) {
        print(" Processing $amount from wallet $accountEmail.")
    }
}