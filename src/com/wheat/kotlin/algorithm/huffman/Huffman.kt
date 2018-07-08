package com.wheat.kotlin.algorithm.huffman

import com.wheat.kotlin.utils.Util
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.LinkedHashMap

class Huffman {
    companion object {
        fun huffAlgorithm(data: ArrayList<Int>): Map<Int, String> {
            //模拟照片的rgb数据
            val freqList = countingFrequency(data)
            val queue = buildPriorityQueue(freqList)
            val rootNode = buildHuffmanTree(queue)
            return buildHuffmanCodeMap(rootNode)
        }

        private fun buildHuffmanCodeMap(rootNode: Node?): Map<Int, String> {
            val huffmanCodeMap = LinkedHashMap<Int, String>(256)
            if (null == rootNode) {
                return huffmanCodeMap
            }
            traverseTree(huffmanCodeMap, "", rootNode)
            return huffmanCodeMap
        }

        //遍历
        private fun traverseTree(huffmanCodeMap: HashMap<Int, String>, parentCode: String, rootNode: Node) {
            if(null!=rootNode.left){
                traverseTree(huffmanCodeMap, parentCode + "0", rootNode.left!!)
            }
            if(null != rootNode.right){
                traverseTree(huffmanCodeMap, parentCode + "1", rootNode.right!!)
            }
            if(null == rootNode.left&&null==rootNode.right&&null != rootNode.value){
                huffmanCodeMap[rootNode.value!!] = parentCode
            }
        }

        private fun buildHuffmanTree(queue: Queue<Node>): Node? {
            var currentNode: Node? = null
            while (queue.isNotEmpty()) {
                currentNode = queue.poll()
                if (queue.isNotEmpty()) {
                    val rightNode = queue.poll()
                    val parentNode = Node(null, currentNode.freq + rightNode.freq)
                    parentNode.left = currentNode
                    parentNode.right = rightNode
                    queue.add(parentNode)
                }
            }
            return currentNode
        }

        private fun countingFrequency(data: ArrayList<Int>): Array<Int?> {
            val frequencyList = arrayOfNulls<Int>(256)
            data.forEach {
                frequencyList[it] = frequencyList[it]?.plus(1) ?: 1
            }
            return frequencyList
        }

        private fun buildPriorityQueue(freqList: Array<Int?>): Queue<Node> {
            val priorityQueue = PriorityQueue<Node>(256)
            freqList.forEachIndexed { index, i ->
                priorityQueue.add(Node(index, i))
            }
            return priorityQueue
        }
    }
}

fun main(args: Array<String>) {
    val data = Util.generateRandomArrayList(1080 * 720 * 3, 256)
    val huffmanCodeMap = Huffman.huffAlgorithm(data)
    println("finish")
    huffmanCodeMap.forEach { t, u -> println("$t:$u") }
}