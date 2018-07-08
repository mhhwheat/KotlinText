package com.wheat.kotlin.algorithm.sort

import com.wheat.kotlin.utils.Util

/**
 * Created by Administrator on 2017/7/22.
 */

class InsertionSort {
    companion object {
        fun sort(list: MutableList<Int>, start: Int, size: Int) {
            if (start < 0 || start >= list.size) {
                throw Exception("out of index")
            }
            if (size < 0) {
                throw Exception("no valid size$size")
            }

            for (i in (start + 1)..(start + size - 1)) {
                var j = i
                while (j > start) {
                    if (list[j] < list[j - 1]) {
                        Util.exchange(list, j - 1, j)
                        j--
                    } else {
                        break
                    }
                }
            }
        }

        fun sort(list: MutableList<Int>) {
            sort(list, 0, list.size)
        }
    }
}

fun main(args: Array<String>) {
    val list = Util.generateRandomList(20)

    println(list.joinToString(","))

    InsertionSort.sort(list)

    println(list.joinToString(","))
}