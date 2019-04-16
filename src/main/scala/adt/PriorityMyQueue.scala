package adt

trait PriorityMyQueue[A] {
  def enqueue(a: A): Unit
  def dequeue(): A
  def peek: A
  def isEmpty: Boolean
}