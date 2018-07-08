package com.wheat.kotlin.algorithm.searchTree

class SearchTree<T : Comparable<T>> {

    var rootNode: Node<T>? = null

    fun add(item: T) {
        val node = Node(item)
        if (null == rootNode) {
            rootNode = node
            return
        }
        var curNode = rootNode
        while (true) {
            if (node.value >= curNode!!.value) {
                if (null == curNode.right) {
                    curNode.right = node
                    node.parent = curNode
                    break
                } else {
                    curNode = curNode.right
                }
            } else {
                if (null == curNode.left) {
                    curNode.left = node
                    node.parent = curNode
                    break
                } else {
                    curNode = curNode.left
                }
            }
        }
    }

    fun transplant(nodeTransplanted: Node<T>, node: Node<T>?) {
        if (null == nodeTransplanted.parent) {
            rootNode = node
            node?.parent = null
            return
        }
        if (nodeTransplanted.parent!!.left == nodeTransplanted) {
            nodeTransplanted.parent!!.left = node
        } else if (nodeTransplanted.parent!!.right == nodeTransplanted) {
            nodeTransplanted.parent!!.right = node
        }
        if (null != node) node.parent = nodeTransplanted.parent
    }

    /**
     * 删除节点的4中可能的情况，图解参考算法导论二叉搜索树(P167)
     */
    fun deleteNode(node: Node<T>) {
        if (null == node.left) {
            //情况一
            transplant(node, node.right)
        } else if (null == node.right) {
            transplant(node, node.left)
        } else {
            //把目标删除节点的最小的后继作为目标删除节点的替代节点，这个替代节点一点不会有前驱
            val minNode = minNode(node.right!!)
            if (minNode.parent == node) {
                transplant(node, minNode)
            } else {
                //把替代节点的后继移交给替代节点的父节点
                transplant(minNode,minNode.right)
                //把目标删除节点的后继移交给新的替代节点
                minNode.right = node.right
                minNode.right!!.parent = minNode
            }

            //把目标删除节点的前驱移交给新的替代节点
            minNode.left = node.left
            minNode.left!!.parent = minNode
        }

    }

    fun delete(item: T) {
        val deletedNode: Node<T>? = searchNode(item) ?: return
        this.deleteNode(deletedNode!!)
    }

    fun search(item: T): T? {
        if (null == rootNode) {
            return null
        }
        var node = rootNode
        while (null != node) {
            node = when {
                item == node.value -> return node.value
                item > node.value -> node.right
                else -> node.left
            }
        }
        return null
    }

    fun max(root: Node<T>): T {
        var node = root
        while (null != node.right) {
            node = node.right!!
        }
        return node.right!!
    }

    fun searchNode(item: T): Node<T>? {
        if (null == rootNode) {
            return null
        }
        var node = rootNode
        while (null != node) {
            node = when {
                item == node.value -> return node
                item > node.value -> node.right
                else -> node.left
            }
        }
        return null
    }

    fun maxNode(root: Node<T>): Node<T> {
        var node = root
        while (null != node.right) {
            node = node.right!!
        }
        return node
    }

    fun minNode(root: Node<T>): Node<T> {
        var node = root
        while (null != node.left) {
            node = node.left!!
        }
        return node
    }
}

fun main(args: Array<String>) {
    val searchTree = SearchTree<Int>()

    searchTree.add(100)
    searchTree.add(101)
}