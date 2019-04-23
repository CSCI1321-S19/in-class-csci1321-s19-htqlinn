package adt

import collection.mutable

class SLList[A] extends mutable.Buffer[A]{
  private class Node(var data: A, var next: Node)
  private var hd: Node = null
  private var tl: Node = null
  private var numElems = 0
  
  def +=(elem: A): this.type = {
    val n = new Node(elem, null)
    if(hd == null){
      hd = n
    }
    else{
      tl.next = n
    }
    numElems += 1
    tl = n
    this
  }
  def +=:(elem: A): this.type = ???
  def apply(n: Int): A = {
    ???
    
  }
  def clear(): Unit = {
    hd = null
    tl = null
    numElems = 0
  }
  def insertAll(n: Int,elems: Traversable[A]): Unit = ???
  def length: Int = numElems
  def remove(n: Int): A = ???
  def update(n: Int,newelem: A): Unit = ???
  
  def iterator: Iterator[A] = ???
}