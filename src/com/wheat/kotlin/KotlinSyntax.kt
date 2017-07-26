package com.wheat.kotlin

/**
 * Created by Administrator on 2017/6/22.
 */

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun sum1(a: Int, b: Int) = a + b

fun printSum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}

var a = 3

fun useStringTemplate() {
    var a = 1
    val s1 = "a is $a"

    a = 2
    val s2 = "${s1.replace("is", "was")},but now is $a"
    s1.replace("is", "are")
    println(s2)
    println(s1)
}

fun maxOf(a: Int, b: Int) = if (a > b) a else b

fun parseInt(str: String): Int? {
    return str.toIntOrNull()
}

fun printProduct(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    if (x != null && y != null) {
        println(x * y)
    } else {
        println("either '$arg1' or '$arg2' is not a number")
    }
}

fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        return obj.length;
    }

    return null
}

fun describe(obj: Any): String =
        when (obj) {
            1           -> "One"
            "Hello"     -> "Greeting"
            is Long     -> "Long"
            !is String  -> "Not a string"
            else        -> "Unknown"
        }

fun main(args: Array<String>) {
    val fruits = listOf("banana","avocado","apple","kiwi")
    fruits.filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }


    /*val items = setOf("apple","banana","wiki")
    when{
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }*/

    /*val items = listOf("apple","banana","kiwi")
    for(item in items){
        println(item)
    }*/

    /*for(x in 1..10 step 2){
        print(x)
    }

    for(x in 9 downTo 0 step 3){
        print(x)
    }*/

    /*for(x in 1..5){
        print(x)
    }*/

    /*val list = listOf("a","b","c")

    if(-1 !in 0..list.lastIndex){
        println("-1 is out of range")
    }
    if(list.size !in list.indices){
        println("list size of out of valid list indices range too")
    }*/

//    val x=10
//    val y = 9
//    if(x in 1..y+1){
//        println("fits in range")
//    }

//    println(describe(1))
//    println(describe("Hello"))
//    println(describe(1000L))
//    print(describe(2))
//    println(describe("other"))

//    val items = listOf("apple", "banana", "kiwi")
//    var index=0
//    while (index < items.size){
//        println("item at $index is ${items[index]}")
//        index++
//    }

//    for (item in items) {
//        println(item)
//    }

//    for (index in items.indices){
//        println("item at $index is ${items[index]}")
//    }

//    fun printLength(obj: Any){
//        println("'$obj' string length is ${getStringLength(obj) ?:"... err, not a string" }")
//    }
//    printLength("Incomprehesibilities")
//    printLength(1000)
//    printLength(listOf(Any()))

//    printProduct("6","7")
//    printProduct("a","7")
//    printProduct("a","b")

//    println("Hello World!")
//    println(sum(3, 5))
//    println(sum1(3, 5))
//    printSum(-1, 8)
//
//    printSum(a,3)
//    useStringTemplate()

//    println("max of 0 and 42 is ${maxOf(0, 42)}")
}