package com.wheat.kotlin.algorithm.huffman

class Node(var value: Int?, freq: Int?) : Comparable<Node> {
    var freq: Int = freq?.let { it } ?: 0
    var left: Node? = null
    var right: Node? = null

    override fun compareTo(other: Node): Int {
        return when {
            other.freq < this.freq -> 1
            other.freq > this.freq -> -1
            else -> 0
        }
    }
}