package com.wheat.kotlin.algorithm.searchTree

class Node<T>(var value: T) {
    var parent: Node<T>? = null
    var left: Node<T>? = null
    var right: Node<T>? = null
}