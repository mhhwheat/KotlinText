package com.wheat.kotlin.algorithm.sort

import com.wheat.kotlin.utils.Util

fun main(arrays: Array<String>) {
    val list = Util.generateRandomList(20)

    println("source:" + list.joinToString(","))

    bubbleSort(list)

    println("result:" + list.joinToString(","))

    val a = Math.pow(5.0, 2.0)
    println(a)
}

fun bubbleSort(list: MutableList<Int>) {
    for (i in 1..list.size) {
        for (j in list.size - 1 downTo i) {
            if (list[j] < list[j - 1]) {
                Util.exchange(list, j - 1, j)
            }
        }
    }
}