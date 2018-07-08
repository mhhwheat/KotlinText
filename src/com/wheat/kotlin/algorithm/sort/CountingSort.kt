package com.wheat.kotlin.algorithm.sort

import com.wheat.kotlin.utils.Util

fun main(args: Array<String>) {
    val list = Util.generateRandomList(20)

    println("source:" + list.joinToString(","))

    val result = countingSort(list)

    if (null == result) {
        println("result:" + "null")
    } else {
        println("result:" + result.joinToString(","))
    }
}

fun max(list: MutableList<Int>): Int {
    var large = Int.MIN_VALUE
    if (list.size <= 0) {
        return large
    }
    for (i in 0..(list.size - 1)) {
        if (large < list[i]) large = list[i]
    }
    return large
}

fun countingSort(list: MutableList<Int>): Array<Int>? {
    val max = max(list)
    if (max <= 0) {
        return null
    }
    System.out.println("max:$max")
//    val result = ArrayList<Int>(list.size)
    val result = Array(list.size, { 0 })
    val countList = ArrayList<Int>(max + 1)
    System.out.println("size:" + countList.size)
    for (i in 0..max) {
        countList.add(0)
    }
    for (i in 0..(list.size - 1)) {
        countList[list[i]]++
    }
    for (i in 1..(countList.size - 1)) {
        countList[i] = countList[i] + countList[i - 1]
    }
    for (i in (list.size - 1) downTo 0) {
        val value = list[i]
        val count = countList[value]
        result[count-1] = value
        countList[value] = count-1//解决存在值相同的时候位置冲突
    }
    return result

}