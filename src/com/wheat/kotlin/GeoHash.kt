package com.wheat.kotlin

val LATITUDE = 180.0
val LONGTITUDE = 360.0

fun main(arrays: Array<String>) {
    generateGeohash(135.8,43.96)
//    println('0'.toInt())
//    println('9'.toInt())
//
//    println('a'.toInt())
//    println('z'.toInt())
//    println('A'.toInt())
//    println('Z'.toInt())
}

/**
 * lat 纬度，lon经度
 */
fun generateGeohash(lat: Double, lon: Double) {

    val latSplitNum = 3
    val lonSplitNum = 3

    val geohashSize = 16

    val latNumArray = getNumArray(lat,geohashSize,latSplitNum, LATITUDE)
    val lonNumArray = getNumArray(lon,geohashSize,lonSplitNum, LONGTITUDE)
    println()
    latNumArray.forEach {
        print(it)
        print(",")
    }
    println()
    lonNumArray.forEach {
        print(it)
        print(",")
    }

    val geohashArray  = arrayOfNulls<Char>(geohashSize)


    for(index in 0..latNumArray.lastIndex){
        val latIndex = latNumArray[index]
        val lonIndex = lonNumArray[index]

        if(latIndex==null||lonIndex==null){
            println("latIndex or lonIndex is null")
            return
        }
        val num = latIndex*lonSplitNum+lonIndex
        if(num < 10){
            geohashArray[index] = '0'+(num)
        }else if(num<36){
            geohashArray[index] = 'a'+(num-10)
        }else if(num<62){
            geohashArray[index] = 'A'+(num-36)
        }else{
            return
        }
    }

    println()
    geohashArray.forEach {
        print(it)
    }
}

fun getNumArray(value: Double, geohashSize: Int, splitNum: Int, valBlockSize:Double): Array<Int?> {
    val numArray = arrayOfNulls<Int>(geohashSize)

    var latValue = value
    var varSplitNum = splitNum
    for (i in 0..numArray.size-1) {
        val blockSize =valBlockSize / varSplitNum
        varSplitNum *= splitNum
//        println("blockSize:"+blockSize)
//        println("latValue:"+latValue)
        numArray[i] = Math.floor(latValue/blockSize).toInt()
        latValue %= blockSize
    }
    return numArray
}