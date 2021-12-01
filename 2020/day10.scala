object Day10 {
//   val input = """
// 28
// 33
// 18
// 42
// 31
// 14
// 46
// 20
// 48
// 47
// 24
// 23
// 49
// 45
// 19
// 38
// 39
// 11
// 1
// 32
// 25
// 35
// 8
// 17
// 7
// 9
// 4
// 2
// 34
// 10
// 3
// """.trim
  val input = """
26
97
31
7
2
10
46
38
112
54
30
93
18
111
29
75
139
23
132
85
78
99
8
113
87
57
133
41
104
98
58
90
13
91
20
68
103
127
105
114
138
126
67
32
145
115
16
141
1
73
45
119
51
40
35
150
118
53
80
79
65
135
74
47
128
64
17
4
84
83
147
142
146
9
125
94
140
131
134
92
66
122
19
86
50
52
108
100
71
61
44
39
3
72
  """.trim
  var numOne = 0
  var numTwo = 0
  var numThree = 0

  def parseInput(i: String): Seq[Int] = {
    i.linesIterator.toList.map{(x: String) => x.toInt}.sorted
  }

  def findHighestAdapter(i: String): Int = {
    parseInput(i).max
  }

  object Part1 {
    def findChain(s: Seq[Int]): Int = {
      var answer = 0
      var currentJolt = 0
      val device = findHighestAdapter(input) + 3

      for (i <- s){
        i match {
          case i if i - currentJolt == 1 => {
            numOne += 1
            currentJolt = i
          }
          case i if i - currentJolt == 2 => {
            numTwo += 1
            currentJolt = i
          }
          case i if i - currentJolt == 3 => {
            numThree += 1
            currentJolt = i
          }
        }
      } 
      if (device - currentJolt == 1) {
        numOne += 1
      } else if (device - currentJolt == 2) {
        numTwo += 1
      } else if (device - currentJolt == 3) {
        numThree += 1
      }
      numOne * numThree
    }
  }

  def main(args: Array[String]): Unit = {
    // Part 2 seems quite time consuming right now, so we'll revisit that at a later date.
    val dataSet = parseInput(input)
    println(s"Day 10, Part 1: ${Part1.findChain(dataSet)}")
    // println(parseInput(input))
  }
}
