package com.wheat.kotlin

import com.wheat.kotlin.utils.Util

fun main(args:Array<String>){
    val list = Util.generateRandomList(20)

    val array=list.toTypedArray()

    println("source:"+array.joinToString(","))

    mergeSort(array,0,list.size-1)

    println("result:"+array.joinToString(","))
}

/**
 *递归归并排序
 */
fun mergeSort(array:Array<Int>,start:Int,end:Int){
    if(start>=end){
        return
    }
    val middle = (start+end)/2
    mergeSort(array,start,middle)
    mergeSort(array,middle+1,end)
    merge(array,start,middle,middle+1,end)
}

fun merge(array:Array<Int>,start1:Int,end1:Int,start2:Int,end2:Int){
    val temArray = arrayOfNulls<Int>(end2-start1+1)
    var index1=start1
    var index2=start2
    var i=0
    while(index1<=end1||index2<=end2){
        if(index1>end1){
            temArray[i]=array[index2]
            index2++
            i++
            continue
        }

        if(index2>end2){
            temArray[i]=array[index1]
            index1++
            i++
            continue
        }

        if(array[index1]<array[index2]){
            temArray[i]=array[index1]
            index1++
            i++
        }else{
            temArray[i]=array[index2]
            index2++
            i++
        }
    }

    var index=start1
    for (item in temArray){
        array[index] = item as Int
        index ++
    }
}