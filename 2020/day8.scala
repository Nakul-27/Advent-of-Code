// RETROSPECTIVE PREFACE:
// THIS CODE IS EXTREMELY SLOPPY AND HACKEY, BUT IT WORKS
// I just went for a solution, not the best or cleanest one.
// In the end this came back to bite me because I had written code that was EXTREMELY difficult to read.
// So if there's a lesson from this it's to just take the time to write efficient and readable code because otherwise you'll be screwed later.
// That's common sense but I chose not to follow it haha.
import scala.collection.mutable.ArrayBuffer
import scala.util.control._
// The input for this problem resembles some assembly language that I did last year at Norwich.
// That being said, I would not like to touch assembly language any more because it was certainly difficult.
// I appreciated the class and what it taught me, however it was quite difficult.
// I'm having some difficulty thinking about how I would want to do this with built in scala functions, but we'll see what happens.
// For the first part, we really only care about the "jmp" command as it will be the one that tells us where we need to be in the list.
// My thought process for solving this is to simply jump forwards and backwards through the instructions after first turning them into a List/Sequence of Tuples.
// Where the tuple is (instruction, count)
// TODO: We can also use a regex to read each line?
// From there, I will load the index of each visited instruction into an ArrayBuffer called visited.
// Doing a simple check to see if we've visited an instruction will tell us when we have.
// Therefore we will have the answer to the first problem.
object Day8 {
//   val commands = """
// nop +0
// acc +1
// jmp +4
// acc +3
// jmp -3
// acc -99
// acc +1
// jmp -4
// acc +6
//   """.trim
  val commands = """
acc +13
jmp +412
nop +137
nop +144
acc +33
acc -11
jmp +445
nop +327
acc -10
jmp +1
jmp +578
jmp +1
jmp +415
acc +25
acc +21
jmp +58
jmp +180
jmp +96
nop +190
acc +20
jmp +167
jmp +194
acc +24
acc +9
acc +14
jmp +1
jmp +443
jmp +1
acc +18
jmp +465
jmp +245
jmp +219
nop +280
acc +13
acc +23
jmp +133
jmp +300
acc +35
acc +50
acc +24
acc +32
jmp +458
acc +36
acc +14
jmp +103
nop +262
jmp +233
acc +14
nop +313
jmp +30
acc +7
jmp +324
acc +12
jmp +1
acc +12
jmp +326
acc +14
nop +151
acc +2
jmp -14
jmp +1
nop +18
jmp +288
acc +24
acc +7
acc +0
jmp +268
jmp +267
acc +3
acc +4
acc +35
jmp +25
jmp -16
acc +14
acc +38
acc +41
jmp +3
acc -16
jmp +546
acc +42
acc -6
acc +38
acc +18
jmp +391
acc +45
jmp +464
jmp +144
acc +33
acc -18
acc +36
jmp +313
jmp +286
acc +34
nop -72
acc -17
jmp +430
acc +35
acc -18
acc -1
jmp +75
acc +48
acc -2
jmp -76
acc -13
nop +453
acc +0
nop +48
jmp +40
acc +40
acc -5
acc +14
acc +1
jmp +323
acc +16
acc +17
nop +408
acc +22
jmp +126
acc +2
jmp +404
acc +22
nop +373
acc -15
jmp +134
np +242
jmp +1
acc +19
jmp +372
acc +18
acc +33
acc +31
acc -12
jmp +417
acc +27
acc -4
jmp +84
nop -86
jmp -87
jmp +174
acc -19
acc +17
nop +353
jmp +301
acc +14
acc -16
acc +2
jmp -109
acc +24
jmp +366
acc -8
acc -14
acc +20
acc +38
jmp -62
acc +4
jmp +1
nop +423
jmp +33
acc -19
acc +50
jmp -128
acc +10
acc +2
jmp +371
acc +31
acc +12
acc +12
jmp +337
acc +42
acc -19
jmp +64
jmp +1
nop -52
jmp -19
acc +34
jmp +287
acc -6
jmp +130
acc +22
acc +22
acc +46
acc -18
jmp +190
acc +13
acc -18
acc +26
jmp +283
acc +15
jmp +193
jmp -168
nop +165
acc -3
acc +26
jmp -54
acc -4
jmp -174
jmp +96
acc +44
acc -18
acc +8
acc +23
jmp -164
acc -11
acc -13
acc +30
jmp +114
acc -9
jmp +386
acc -15
jmp +98
nop -74
acc +31
acc -4
acc +15
jmp +113
acc -3
acc +36
jmp +362
jmp +225
jmp +131
acc +14
acc +48
acc -16
nop +302
jmp +383
acc -14
jmp +97
acc +5
acc -6
jmp -4
acc +27
jmp +165
acc +49
jmp +36
nop -213
acc +30
acc +18
jmp +1
jmp +54
nop +73
nop +185
acc -4
jmp -156
acc +17
jmp +1
acc +30
jmp +357
nop +60
jmp +1
jmp -186
acc -17
acc +26
acc +45
jmp +74
acc +27
acc +1
jmp -109
acc +49
acc +4
jmp +298
acc +12
jmp -42
acc -16
jmp -195
acc +19
acc -13
acc +31
acc +31
jmp +201
jmp +274
jmp +1
acc +27
acc +41
acc +35
jmp +9
nop +32
jmp -190
acc +2
jmp +1
jmp +172
acc +10
acc -13
jmp -95
acc -10
acc -12
acc -4
jmp +290
nop -91
nop +288
acc +45
acc +40
jmp +322
acc +9
jmp +314
acc -10
acc +3
nop -62
acc +46
jmp +186
acc +14
acc +40
acc +49
acc +29
jmp -175
acc +37
acc -8
jmp +254
jmp +48
acc +30
acc +40
jmp +1
jmp -172
acc -9
acc +42
nop -269
jmp -154
nop +109
acc +0
jmp -68
acc +40
jmp +310
acc +4
jmp +266
jmp +80
acc +15
acc -14
jmp -206
acc +17
jmp +156
acc -19
acc +25
nop +82
acc +13
jmp +243
jmp +259
jmp +258
acc +29
acc +9
jmp -76
acc +5
acc +41
acc +49
acc +17
jmp +161
acc +29
nop +215
jmp +179
acc +45
acc +23
jmp +208
acc +3
acc +30
jmp +38
nop +204
jmp -62
jmp +1
acc +10
jmp +78
acc +32
acc +29
jmp -269
acc +20
acc +24
jmp +1
jmp -114
jmp +160
acc -19
jmp +137
nop -312
acc +8
acc +3
jmp -181
jmp +122
acc +9
jmp -166
jmp -106
jmp +98
jmp -152
acc -7
acc +19
jmp +180
jmp +195
acc -17
acc +19
acc +8
acc +21
jmp +193
jmp +226
acc +5
jmp +14
jmp +228
acc +44
nop +112
acc +0
acc +12
jmp +223
acc +21
nop +87
acc +32
acc +42
jmp -264
acc +31
jmp +49
acc -3
acc +16
nop -277
acc +45
jmp +50
acc +0
acc +7
nop -223
acc +11
jmp +113
acc +32
acc +20
jmp +108
acc -7
acc +30
jmp +66
acc -12
acc +34
acc -9
acc +39
jmp +126
jmp -351
jmp -89
jmp -45
acc +4
acc +7
acc -1
acc +41
jmp -229
acc -9
acc +29
jmp -115
acc +27
acc -11
jmp +187
acc -10
acc +11
acc +29
acc +46
jmp -115
nop -116
acc +31
jmp -202
acc +12
jmp +1
acc +16
acc +15
jmp -25
acc -7
jmp -439
acc +10
acc +26
acc +13
jmp -75
nop -214
acc +2
nop -202
jmp +105
jmp -65
acc -15
acc +6
jmp +1
jmp -182
acc +13
acc -19
jmp +26
acc +20
acc -16
acc +14
jmp -59
jmp -204
acc +27
acc +44
nop -33
acc +36
jmp -300
acc +48
acc +28
acc +29
acc +39
jmp -249
acc +33
acc +31
jmp +1
acc +33
jmp -269
acc +8
acc +31
acc +10
acc +5
jmp -194
jmp -477
nop -196
acc +50
acc -13
jmp -47
nop +77
acc +45
jmp -293
acc +39
jmp -19
nop -391
acc +28
acc +50
acc +16
jmp -209
acc -1
acc +39
acc -17
nop -233
jmp -283
acc +19
acc +0
acc +22
acc +22
jmp -488
acc +39
nop -286
acc +33
jmp -23
jmp -173
jmp -274
acc +5
acc +45
acc +0
acc -14
jmp -342
acc +16
acc +28
nop -155
jmp -488
acc +12
acc +28
nop -181
acc +17
jmp -447
acc +40
acc +40
acc +13
jmp -38
acc -12
nop -494
acc +43
jmp -533
acc +30
jmp -518
acc +39
acc +4
nop -179
jmp -127
acc +31
acc +42
acc +17
jmp -82
nop -520
jmp -521
jmp -193
acc -8
jmp -142
jmp +1
acc +39
jmp -532
acc +30
acc +3
acc +22
nop -84
jmp +2
jmp -402
jmp -468
acc +0
acc -4
acc -19
jmp -379
jmp -357
acc +0
jmp -159
acc +13
acc +24
acc -3
acc +0
jmp -387
acc +31
acc +20
acc +27
jmp -308
jmp -161
acc -6
nop -163
acc -3
jmp -585
nop -586
nop -6
acc +10
acc +42
jmp -590
acc +0
acc +34
acc +16
acc +9
jmp -175
acc +29
jmp -217
acc +0
jmp -234
jmp -47
acc +28
acc +0
acc +25
acc -5
jmp -556
nop -144
jmp +1
acc +27
jmp -117
jmp -10
acc +24
acc -17
acc +9
acc +18
jmp -310
jmp -455
nop -437
jmp -593
acc +15
acc +50
acc -3
jmp -50
acc -13
acc +14
acc +34
acc -16
jmp +1
  """.trim
  // We need to program the 3 instructions, Accumulator, Jump, No Operation.
  type Instruction = (String, Int)

  var visited = new ArrayBuffer[Int]()
  var newVisited = new ArrayBuffer[Int]()

  var totalAccumulated = 0

  sealed trait Over {
    def parseInstructions(getInstructions: String => List[String], createLists: List[String] => List[List[String]], commands: String): List[Instruction] = {
      val commandList = getInstructions(commands)
      createLists(commandList).map{x => (x(0),x(1).toInt)}
    }
    def readInstructions(instructions: List[Instruction]): Int
  }

  object Part1 extends Over {
    override def readInstructions(instructions: List[Instruction]): Int = {
      // I can't think of how to do this functionally,
      // so I'm going to try to use a while loop and jump through the list
      // until the we reach the same instruction twice.

      // index of the List[Instructions] that we're going to go through.
      var index = 0
      var loop = true
      var answer = 0

      while(loop) { 
        instructions(index)._1 match {
          case "acc" => {
            if (visited.contains(index)) {
              answer = totalAccumulated
              loop = false
            }
            visited += index
            totalAccumulated += instructions(index)._2
            index += 1
          } 
          case "jmp" => {
            if (visited.contains(index)) {
              answer = totalAccumulated
              loop = false
            }
            visited += index
            index += instructions(index)._2
          }
          case "nop" => {
            if (visited.contains(index)) {
              answer = totalAccumulated
              loop = false
            }
            visited += index
            index += 1
          }
        }
      }
      totalAccumulated = 0
      answer
    }
  }

  // For this one we can replace all of the operations that we have visited.
  // Each time we change an instruction, we can read the instructions again
  // and we can see if the size of visited is equal to the number of instructions.
  // This will tell us if we have found the instruction to replace.
  object Part2 extends Over {
    override def readInstructions(instructions: List[Instruction]): Int = {
      // index of the List[Instructions] that we're going to go through.
      var index = 0
      var loop = true
      var answer = 0
      val loopBreak = new Breaks
      totalAccumulated = 0
      newVisited.clear()
      loopBreak.breakable {
        while(loop) { 
          instructions(index)._1 match {
            case "acc" => {
              if (!newVisited.contains(index)) { // Not seen the index before
                newVisited += index
                totalAccumulated += instructions(index)._2
                if (instructions.indexOf(instructions.last) == index) {
                  index += 0
                } else { 
                  index += 1 
                }
              } else { //newVisited.contains(index) = true meaning we've seen the index before. (In a loop)
                answer = totalAccumulated
                // totalAccumulated -= instructions(index)._2
                loop = false
                loopBreak.break()
              }
            } 
            case "jmp" => {
              if (!newVisited.contains(index)) { 
                newVisited += index 
              } else {
                loop = false
                loopBreak.break()
              }
              // if (index == (instructions.size - 1)) {
              //   loop = false
              //   loopBreak.break()
              // }
              if (index == (instructions.size - 1) || (index + instructions(index)._2) > (instructions.size - 1) || (index + instructions(index)._2) < 0) {
                loop = false
                loopBreak.break()
              } else if (instructions(index)._2 == 0) {
                index += 1
              } else {
                index += instructions(index)._2
              }
            }
            case "nop" => {
              if (!newVisited.contains(index)) {
                newVisited += index
              } else {
                answer = totalAccumulated
                totalAccumulated -= instructions(index)._2
                loop = false
                loopBreak.break()
              }
              if (instructions.indexOf(instructions.last) == index) { 
                index += 0 
              } else { 
                index += 1
              }
            }
          }
          if (newVisited.size == instructions.size) {
            answer = totalAccumulated
            loop = false
            loopBreak.break()
          }
        }
      }
      totalAccumulated
    }

    // Inefficient but it'll work for now.
    def changeInstruction(visited: ArrayBuffer[Int], instructions: List[Instruction]): Int = {
      var loop = true
      val loopBreak = new Breaks
      val oldSize = readInstructions(instructions)
      var newInstructions = instructions.toArray
      var newSize = 0
      loopBreak.breakable {
        for (index <- visited) {
          newSize = 0
          instructions(index)._1 match {
            case "acc" =>  None 
            case "nop" => {
              newInstructions(index) = newInstructions(index).copy(_1 = "jmp")
              newSize = readInstructions(newInstructions.toList)
              if (newSize > oldSize && newVisited.last == instructions.size) {
                loop = false
                loopBreak.break()
              } else {
                newSize = 0
              }
              newInstructions(index) = newInstructions(index).copy(_1 = "nop")
            }
            case "jmp" => {
              newInstructions(index) = newInstructions(index).copy(_1 = "nop")
              newSize = readInstructions(newInstructions.toList)
              if (newVisited.last == (instructions.size - 1)) {
                loop = false
                loopBreak.break()
              } else {
                newSize = 0
              }
              newInstructions(index) = newInstructions(index).copy(_1 = "jmp")
            }
          }
        }
      }
      newSize
    }
  }

  // We can turn the commands into a list like Day 6
  def getInstructions(commands: String): List[String] = {
    commands.linesIterator.toList 
  }

  def createLists(commandList: List[String]): List[List[String]] = {
    commandList.map{_.split(" ").toList} 
  }

  def main(args: Array[String]): Unit = {
    val parsedInstructions = Part1.parseInstructions(getInstructions, createLists, commands)
    println(s"Day 8, Part 1: ${Part1.readInstructions(parsedInstructions)}")
    println(s"Day 8, Part 2: ${Part2.changeInstruction(visited, parsedInstructions)}")
  }
}
