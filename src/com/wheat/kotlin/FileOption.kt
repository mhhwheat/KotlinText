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
    println(contents)

    file.forEachLine(action = ::println)

    file.forEachLine {
        print(it.length.toString()+":")
        println(it)
    }

    val bytes:ByteArray = file.readBytes()
    println(bytes.joinToString(separator = ""))
}