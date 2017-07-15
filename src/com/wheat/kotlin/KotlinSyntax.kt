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

fun parseInt(str:String): Int?{
    return str.toIntOrNull()
}

fun printProduct(arg1: String, arg2: String){
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    if(x!=null&&y!=null){
        println(x*y)
    }else{
        println("either '$arg1' or '$arg2' is not a number")
    }
}

fun main(args: Array<String>) {
    printProduct("6","7")
    printProduct("a","7")
    printProduct("a","b")

//    println("Hello World!")
//    println(sum(3, 5))
//    println(sum1(3, 5))
//    printSum(-1, 8)
//
//    printSum(a,3)
//    useStringTemplate()

//    println("max of 0 and 42 is ${maxOf(0, 42)}")
}