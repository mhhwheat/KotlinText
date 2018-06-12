package com.wheat.kotlin.algorithm.sort

import com.wheat.kotlin.utils.Util

fun main(args: Array<String>) {
    val list = Util.generateRandomList(1000)

    println("source:" + list.joinToString(","))

    quickSort(list, 0, list.size - 1)

    println("result:" + list.joinToString(","))
}

fun quickSort(list: MutableList<Int>, start: Int, end: Int) {
    if (end <= start) return
    var middleIndex = end
    var direction = 1
    var currentIndex = start
    while ((direction>0&&currentIndex<middleIndex)||(direction<0&&currentIndex>middleIndex)){
        if(direction>0){
            if(list[currentIndex]>list[middleIndex]){
                val temp = middleIndex
                middleIndex = currentIndex
                currentIndex = temp
                Util.exchange(list,middleIndex,currentIndex)
                direction = -1
            }
            currentIndex+=direction
        }else{
            if(list[currentIndex]<list[middleIndex]){
                val temp = middleIndex
                middleIndex = currentIndex
                currentIndex = temp
                Util.exchange(list,middleIndex,currentIndex)
                direction = 1
            }
            currentIndex+=direction
        }
    }
    quickSort(list,start,middleIndex-1)
    quickSort(list,middleIndex+1,end)
}