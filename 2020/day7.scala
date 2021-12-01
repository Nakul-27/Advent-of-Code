// WHILE I HAVE AN IDEA OF HOW TO DO THIS PROBLEM, I THINK THAT IT WILL TAKE A WHILE. I WILL LEAVE THIS PROBLEM INCOMPLETE FOR NOW.
// This one is interesting for sure. 
// Just by taking a quick look at the problem, I think that we can create small trees from each line of input.
// We're going to be using more regexes in this one from what I can tell.
// We'll read the input in and then parse each line using a regex and then create a tree through it.
// I've never created a tree in scala before, so this will be intersting to say the least. 
// I think that this will be fun, so we'll see what happens.
// *time passes...*
// Upon some research I found that using a Tree on it's own would be pretty useless.
// I think that a Tree Map or something of that sort might be useful to use.
// A side note, from being in Data Structures last year, I remember having to parse infix and postfix text and create a calculator in C++.
// Scala is different, however I am sure that I will need to use recursion in order to traverse down each tree and find out if it contains 
// the bag that I am looking for.
// I saw that I could use "@tailrec" in order to use recursion that will be optimized by the compiler: https://www.geeksforgeeks.org/tail-recursion-in-scala/
// I believe that you need to use @tailrec as a function within a function that gets called.
// Regex Cheatsheet: https://regexcheatsheet.com
import scala.annotation.tailrec

object Day7 {
  val input = """
light red bags contain 1 bright white bag, 2 muted yellow bags.
dark orange bags contain 3 bright white bags, 4 muted yellow bags.
bright white bags contain 1 shiny gold bag.
muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.
shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.
dark olive bags contain 3 faded blue bags, 4 dotted black bags.
vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.
faded blue bags contain no other bags.
dotted black bags contain no other bags.
  """.trim

  val rulesRegex = """(.+) bags contains (.+)""".r

  def main(args: Array[String]): Unit = {
    println("Hello World")
  }
}
