package com.example

import com.dummy.libs.MathHelper
import com.dummy.libs.StringHelper


fun main() {
    val user = User(id = 1, name = "Bart Simpson", age = 12)
    println("user: $user")
    println("add(1,1): ${MathHelper.add(1,1)}")
    println("addOne(1): ${MathHelper.addOne(1)}")
    print("addNewLine(\"abc\"): ${StringHelper.addNewLine("abc")}")
}