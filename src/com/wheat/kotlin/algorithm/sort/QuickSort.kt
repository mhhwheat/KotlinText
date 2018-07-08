package com.wheat.kotlin.algorithm.sort

import com.wheat.kotlin.utils.Util

class QuickSort {
    companion object {
        fun sort(list: MutableList<Int>, start: Int, end: Int) {
            if (end <= start) return
            val middleIndex = QuickSort.partition(list, start, end)
            this.sort(list, start, middleIndex - 1)
            this.sort(list, middleIndex + 1, end)
        }

        fun partition(list: MutableList<Int>, start: Int, end: Int): Int {
            var middleIndex = end
            var direction = 1
            var currentIndex = start
            while ((direction > 0 && currentIndex < middleIndex) || (direction < 0 && currentIndex > middleIndex)) {
                if (direction > 0) {
                    if (list[currentIndex] > list[middleIndex]) {
                        val temp = middleIndex
                        middleIndex = currentIndex
                        currentIndex = temp
                        Util.exchange(list, middleIndex, currentIndex)
                        direction = -1
                    }
                    currentIndex += direction
                } else {
                    if (list[currentIndex] < list[middleIndex]) {
                        val temp = middleIndex
                        middleIndex = currentIndex
                        currentIndex = temp
                        Util.exchange(list, middleIndex, currentIndex)
                        direction = 1
                    }
                    currentIndex += direction
                }
            }
            return middleIndex
        }
    }
}

fun main(args: Array<String>) {
    val list = Util.generateRandomList(1000)

    println("source:" + list.joinToString(","))
0






























































































































































    QuickSort.sort(list, 0, list.size - 1)

    println("result:" + list.joinToString(","))
}