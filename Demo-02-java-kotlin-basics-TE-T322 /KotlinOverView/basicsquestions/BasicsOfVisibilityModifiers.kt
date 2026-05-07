package com.example.kotlin_practice.basicsquestions

private fun logDebug(message: String) = print("Message is: $message")
// This function cannot use out side file
// If it is internal than it only used in side the Current Module for this case: app module

/*
Create an open class System. Inside it, declare a protected val version: String initialized to "2.0"
 */
open class System(protected val version: String = "2.0")
//Here the version property is protected it means it only accessible in System Class and its child class
//If it is private than only inside System class only
//And for public and package it same as top-level visibility