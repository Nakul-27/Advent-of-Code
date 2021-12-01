// My first thought for this is to use a Queue, so we'll see what I come up with after some research.
// After reading this article: https://www.geeksforgeeks.org/queue-in-scala/
// And this article: https://alvinalexander.com/scala/how-to-use-queue-class-in-scala-enqueue-dequeue/
// A queue seems like it'll work.
import scala.collection.mutable._

object Day22 {
//   val input = """
// Player 1:
// 9
// 2
// 6
// 3
// 1
// 
// Player 2:
// 5
// 8
// 4
// 7
// 10
// """.trim
  val input = """
Player 1:
21
50
9
45
16
47
27
38
29
48
10
42
32
31
41
11
8
33
25
30
12
40
7
23
46

Player 2:
22
20
44
2
26
17
34
37
43
5
15
18
36
19
24
35
3
13
14
1
6
39
49
4
28
""".trim

  case class Player(num: Int, moves: Queue[Int])

  // Regex for each Player's input
  // Had to look back at Day 21 for some help with the Regex.
  val playerRegex = """Player (\d):\n([(\d)+\n]+)*""".r

  sealed trait Part {
    def getWinningPlayer(l: List[Player]): Player

    def getWinningScore(p: Player): Int = {
      var index = 1
      var totalScore = 0
      p.moves.reverse.foreach{ x => {
        totalScore += x * index
        index += 1
      } }
      totalScore
    }
  }

  object Part1 extends Part{
    override def getWinningPlayer(l: List[Player]): Player = {
      var playersTurn = 1
      val listPlayers = parseInput(input)
      val totalCards = listPlayers.map(x => x.moves.size).sum

      val p1 = l(0)
      val p2 = l(1)

      // TODO: Figure out how to do this functionally
      while (p1.moves.size != totalCards && p2.moves.size != totalCards) {
        if (p1.moves(0) > p2.moves(0)) {
          val removeCards = (p1.moves(0), p2.moves(0))
          p1.moves.dequeue()
          p2.moves.dequeue()
          p1.moves.enqueue(removeCards._1,removeCards._2)
        } else if (p1.moves(0) < p2.moves(0)) {
          val removeCards = (p2.moves(0), p1.moves(0)) 
          p1.moves.dequeue()
          p2.moves.dequeue()
          p2.moves.enqueue(removeCards._1, removeCards._2)
        } else if (p1.moves(0) == p2.moves(0)) {
        }
      }
      if (p1.moves.size == totalCards) p1
      else p2
    }
  }

  // Parse the input
  def parseInput(s: String): List[Player] = {
    // s.split("\n\n").toList
    s.split("\n\n").map{ case playerRegex(playerNum, moves) => {
      val movesQueue = Queue[Int]()
      moves.split("\n").foreach(x => movesQueue.enqueue(x.toInt))
      Player(playerNum.toInt, movesQueue)
    } }.toList
  }

  def main(args: Array[String]): Unit = {
    import Part1._
    val parsedInput = parseInput(input)
    val winningPlayer = getWinningPlayer(parsedInput)
    val winningScore = getWinningScore(winningPlayer)
    println(s"Day 22, Part 1: ${winningScore}")

    // println("Hello World")
  }
}
