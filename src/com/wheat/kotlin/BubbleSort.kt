package com.wheat.kotlin

import com.wheat.kotlin.utils.Util

fun main(arrays : Array<String>){
    val list = Util.generateRandomList(20)

    println("source:"+list.joinToString(","))

    bubbleSort(list)

    println("result:"+list.joinToString(","))

    val a=Math.pow(5.0,2.0)
    println(a)
}

fun bubbleSort(list: MutableList<Int>){
    for (i in 1..list.size){
        for(j in list.size-1 downTo i){
            if(list[j]<list[j-1]){
                exchange(list,j-1,j)
            }
        }
    }
}

fun exchange(list: MutableList<Int>,i:Int,j:Int){
    val key = list[i]
    list[i]=list[j]
    list[j]=key
}