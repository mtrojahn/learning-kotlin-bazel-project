package com.example

import com.dummy.libs.MathHelper
import com.dummy.libs.StringHelper
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString


fun main() {
    // if the srcs are set right on the BUILD file I'm able to use the User class from OtherClasses.kt
    val user = User(id = 1, name = "Bart Simpson", age = 12)
    println("user: $user")

    // if the deps and aliases for the dummy.libs are set right, I should have no problem using the helper
    // class on that lib
    println("add(1,1): ${MathHelper.add(1,1)}")
    println("addOne(1): ${MathHelper.addOne(1)}")
    print("addNewLine(\"abc\"): ${StringHelper.addNewLine("abc")}")

    // if everything is right with maven configuration, I should be able to use kotlinx-serialization here.
    println(Json.encodeToString(user))

}