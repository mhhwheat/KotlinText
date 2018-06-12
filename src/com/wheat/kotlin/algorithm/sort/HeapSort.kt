package com.wheat.kotlin.algorithm.sort

import com.wheat.kotlin.utils.Util

var heapSize = -1
var operationCount = 0;

fun main(args: Array<String>) {
    val list = Util.generateRandomList(20)

    println("source:" + list.joinToString(","))

    heapSort(list)

    println("result:" + list.joinToString(","))

    println("operation count:$operationCount")
}

fun maxHeapify(list: MutableList<Int>, index: Int) {
    operationCount++
    var large = index
    val left = index * 2
    val right = index * 2 + 1
    if (left <= heapSize && list[large - 1] < list[left - 1]) {
        large = left
    }
    if (right <= heapSize && list[large - 1] < list[right - 1]) {
        large = right
    }
    if (index != large) {
        Util.exchange(list, large - 1, index - 1)
        maxHeapify(list, large)
    }
}

fun buildMaxHeap(list: MutableList<Int>) {
    heapSize = list.size
    for (i in (list.size / 2) downTo 1) {
        maxHeapify(list, i)
    }
}

fun heapSort(list: MutableList<Int>) {
    buildMaxHeap(list)
    for (i in list.size downTo 2) {
        //最大值与叶节点交换
        Util.exchange(list, 0, i - 1)
        heapSize = i - 1 //修改堆的大小
        maxHeapify(list, 1)
    }
}