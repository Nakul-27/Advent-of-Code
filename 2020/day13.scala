object Day13 {
//   val input = """
// 939
// 7,13,x,x,59,x,31,19
// """.trim
  val input = """
1015292
19,x,x,x,x,x,x,x,x,41,x,x,x,x,x,x,x,x,x,743,x,x,x,x,x,x,x,x,x,x,x,x,13,17,x,x,x,x,x,x,x,x,x,x,x,x,x,x,29,x,643,x,x,x,x,x,37,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,23
""".trim

  object Part1 {
    def findAnswer(l: (Int, List[List[Int]]), check: List[Int]): Int = {
      var lowest = l._1
      var index = 0
      // This isn't going to be efficient but it'll work.
      l._2.foreach{ x => x.foreach {
        y => if ((y - l._1) < lowest) { index = l._2.indexOf(x); println(y); lowest = y - l._1; println(lowest) }
      } }
      println(s"Check(index) ${check(index)}")
      println(s"Lowest: ${lowest}")
      lowest * check(index)
    }
  }

  def getTail(s: String): List[Int] = {
    s.split("\n").last.split(",").toList.collect{case x if x != "x" => x.toInt} 
  }

  def getHead(s: String): Int = {
    s.split("\n").head.toInt
  }

  def parseInput(s: String): (Int, List[Int]) = {
    // We can use the collect function to filter out the 'x.'
    // Article: http://allaboutscala.com/tutorials/chapter-8-beginner-tutorial-using-scala-collection-functions/scala-collect-function/
    val head = getHead(s)
    val tail = getTail(s)
    (head, tail)
  }

  // Article on Filter: https://alvinalexander.com/scala/how-to-use-filter-method-scala-collections-cookbook/
  def multValues(l: (Int, List[Int])): (Int, List[List[Int]]) = {
    (l._1, l._2.map{
      x => (0 to 2000).map{
        y => x * y
      }.toList.filter{_ > l._1}
    })
  }

  def main(args: Array[String]): Unit = {
    val inputTuple = parseInput(input)
    // println(parseInput(input))
    val multValuesList = multValues(inputTuple)
    // println(multValuesList)
    val check = getTail(input)
    // println(multValues(inputTuple))
    println(Part1.findAnswer(multValuesList, check))
  }
}
