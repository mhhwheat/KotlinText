package com.wheat.kotlin

import com.wheat.kotlin.utils.Util

/**
 * Created by Administrator on 2017/7/22.
 */


fun main(args: Array<String>) {
//    for(num in Util.generateRandomList(100)){
//        println(num)
//    }
    val list = Util.generateRandomList(20)

    println(list.joinToString(","))

    for (i in 1..(list.size - 1)) {
        var j = i - 1
        while (j >= 0 && list[j] > list[j + 1]) {
            val ex = list[j + 1]
            list[j + 1] = list[j]
            list[j] = ex
            j--
        }
    }

    println(list.joinToString(","))
}