package com.wheat.kotlin

import java.io.File

/**
 * Created by Administrator on 2017/7/26.
 */
fun main(args : Array<String>){
    readFile()
}

fun readFile(){
    val fileName="D:\\GitProject\\KotlinTest\\input\\fileOption.txt"
    val file = File(fileName)
    val contents = file.readText()
    println("输出方式1：")
    println(contents)

    println("输出方式2：")
    file.forEachLine(action = ::println)

    println("输出方式3：")
    file.forEachLine {
        print(it.length.toString()+":")
        println(it)
    }

    println("输出方式4：")
    val bytes:ByteArray = file.readBytes()
    println(bytes.joinToString(separator = ""))
}