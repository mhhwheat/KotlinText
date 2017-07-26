package com.wheat.kotlin

import java.io.File

/**
 * Created by Administrator on 2017/7/26.
 * 两个n位的二进制数组相加
 */

fun main(args: Array<String>) {
    val file = File("D:\\GitProject\\KotlinTest\\input\\fileOption.txt")
    var lineNum = 0
    var n = 0
    var lines = file.readLines()
    if(lines.size<3){
        println("line small than 3")
        return
    }
    n = Integer.parseInt(lines[0])

    var aArray = arrayOfNulls<Int>(n)
    var bArray = arrayOfNulls<Int>(n)

    lines[1].split(',').forEachIndexed{
        index,value -> aArray[index] = parseInt(value)
    }

    lines[2].split(',').forEachIndexed{
        index,value -> bArray[index] = parseInt(value)
    }

    println(aArray.joinToString(separator = ","))
    println(bArray.joinToString(separator = ","))
}