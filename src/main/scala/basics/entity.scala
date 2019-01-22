package basics

class entity (
   private var x: Double,
   private var y: Double
)  { 
   private val width = 1.0
   private val height = 1.0
   
   def intersects(e:entity):Boolean = {
     val overlapX = (x - e.x).abs < (width + e.width) / 2
     val overlapY = (y - e.y).abs < (height + e.height) / 2
     overlapX && overlapY
   }
}

//companion object 
object entityTest {
  def main(args:Array[String]): Unit = {
    val e1 = new entity(0,0)
    val e2 = new entity(0,0)
    println(e1.intersects(e2))
    val e3 = new entity(10,0)
    println(e1.intersects(e3))
  }
  
}