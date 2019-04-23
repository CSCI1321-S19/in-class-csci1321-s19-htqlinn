package basics

object Graphs extends App {
  val graph = Array(
    Array(0, 1, 0, 1, 1, 0),
    Array(0, 0, 1, 0, 0, 1),
    Array(1, 0, 0, 0, 1, 0),
    Array(0, 0, 1, 0, 0, 0),
    Array(0, 0, 0, 0, 0, 1),
    Array(0, 0, 0, 0, 0, 0))

  def reachable(node1: Int, node2: Int, connect: Array[Array[Int]], visited: Set[Int] = Set.empty): Boolean = {
    if (node1 == node2) true else {
      val newVisited = visited + node1
      var i = 0
      var ret = false
      while (!ret && i < connect.length) {
        if (connect(node1)(i) != 0 && !visited(i)) ret |= reachable(i, node2, connect)
        i += 1
      }
      ret
    }
  }

  def shortestPath(node1: Int, node2: Int, connect: Array[Array[Int]], visited: Set[Int] = Set.empty): Int = {
    if (node1 == node2) 0 else {
      val newVisited = visited + node1
      var i = 0
      var ret = 1000000000
      while (i < connect.length) {
        if (connect(node1)(i) != 0 && !visited(i)) ret = ret min shortestPath(i, node2, connect)
        i += 1
      }
      ret + 1
    }
  }

  def quicksort[A](arr: Array[A])(lt: (A, A) => Boolean): Unit = {
    def helper(start: Int, end: Int):Unit = {
      if(end - start > 1){
        val p = start + util.Random.nextInt(end-start)
        val tmp = arr(p)
        arr(p) = arr(start)
        arr(start) = tmp
        var low = start+1
        var high = end-1
        while(low <= high){
          if(lt(arr(low), arr(start))) {
            low += 1
          } else {
            val tmp = arr(low)
            arr(low) = arr(high)
            arr(high) = tmp
            high -= 1
          }
        }
        val tmp2 = arr(start)
        arr(start) = arr(high)
        arr(high) = tmp2
        //helper
      }
    }
    helper(0, arr.length)
  }

  println(shortestPath(0, 5, graph))
  println(shortestPath(4, 3, graph))
  println(shortestPath(3, 5, graph))

  def quicksort[A](lst: List[A])(lt: (A, A) => Boolean): List[A] = lst match {
    case Nil => Nil
    case h :: Nil => lst
    case pivot :: t =>
      val (less, greater) = t.partition(a => lt(a, pivot))
      quicksort(less)(lt) ::: (pivot :: quicksort(greater)(lt))
  }

  val numList = List.fill(15)(util.Random.nextInt(100))
  println(quicksort(numList)(_ < _))

}