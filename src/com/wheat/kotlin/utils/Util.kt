package com.wheat.kotlin.utils

import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by Administrator on 2017/7/22.
 */

class Util {
    companion object {
        fun generateRandomList(size: Int): MutableList<Int> {
            var randomList = mutableListOf<Int>()

            for (i in 1..size) {
                randomList.add(Random().nextInt(size * 10))
            }

            return randomList
        }

        fun generateRandomArrayList(size: Int, bound: Int): ArrayList<Int> {
            var randomList = arrayListOf<Int>()
            for (i in 1..size) {
                randomList.add(Random().nextInt(bound))
            }
            return randomList
        }

        fun generateRandomMutableList(size: Int, bound: Int): MutableList<Int> {
            var randomList = mutableListOf<Int>()
            for (i in 1..size) {
                randomList.add(Random().nextInt(bound))
            }
            return randomList
        }

        fun exchange(list: MutableList<Int>, i: Int, j: Int) {
            val key = list[i]
            list[i] = list[j]
            list[j] = key
        }
    }
}