/*1. Create a class called ImageGallery that implements your Swipeable interface.
Override the onSwipeRight() function to print the text "Loading next image".
 */
interface Swipeable {
    fun onSwipeRight()
}
class ImageGallery: Swipeable {
    override fun onSwipeRight() {
        print("Swiping Right side.")
    }
}
/*2. Create an interface Document with an abstract fun read().
Create a second interface EditableDocument that inherits from Document and adds an abstract fun write().
(Do not create a class, just the two interfaces).
 */
interface Document {
    fun read()
}
interface EditableDocument: Document {
    fun write()
}

/* 3. Create an interface Camera with a default fun open() { println("Camera open") }.
Create an interface Gallery with a default fun open() { println("Gallery open") }.
Create a class PhotoApp that implements both, overrides open(), and calls only the Gallery interface's open() function.
 */
interface Camera {
    fun open() { println("Camera Open") }
}
interface Gallery {
    fun open() { println("Gallery Open") }
}
class PhotoApp: Camera, Gallery {
    override fun open() {
        super<Camera>.open()
    }
}