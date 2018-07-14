package com.wheat.kotlin.algorithm.searchTree

class Node<T>(var value: T) {
    var parent: Node<T>? = null
    var left: Node<T>? = null
    var right: Node<T>? = null

    override fun toString(): String {
        var result = ""
        result += value.toString()
        result += "("
        result += if (null == left) {
            "null"
        } else {
            left!!.value.toString()
        }
        result += ","
        result += if (null == right) {
            "null"
        } else {
            right!!.value.toString()
        }
        result += ")"
        return result
    }
}