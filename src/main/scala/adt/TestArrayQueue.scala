package adt

import org.junit.Test
import org.junit.Assert._

class TestArrayQueue {
  @Test def emptyOnCreate(): Unit = {
    val queue = new ArrayQueue[Int]
    assertTrue(queue.isEmpty)
  }
  
  @Test def addOneAndDequeue(): Unit = {
    val queue = new ArrayQueue[Int]
    queue.enqueue(5)
    assertFalse(queue.isEmpty)
    assertEquals(5, queue.peek)
    assertEquals(5, queue.dequeue())
    assertTrue(queue.isEmpty)
  }
  
  
}