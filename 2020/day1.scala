object Day1 {

  val entries = List( 1150, 1579, 1361, 1319, 1201, 1253, 1806, 1783, 1164, 1772, 1920, 1428, 1918, 245, 1504, 1952, 1057, 1977, 704, 1119, 1971, 1200, 1650, 1795, 1877, 1932, 1811, 1981, 1803, 1366, 1580, 1986, 1976, 1063, 1895, 1143, 1991, 1061, 1855, 1947, 1134, 1800, 1898, 1778, 1964, 1949, 1103, 1770, 1321, 2005, 1758, 1181, 1140, 1873, 1946, 1540, 1909, 1710, 1705, 1313, 1196, 1084, 1870, 1610, 1708, 1810, 1133, 1375, 1264, 1921, 1624, 41, 1899, 1226, 1757, 1978, 1485, 1385, 1526, 1653, 1130, 1223, 1577, 1912, 1894, 276, 954, 1269, 1769, 1924, 93, 1165, 1812, 1092, 1402, 1284, 1903, 1884, 1581, 1887, 1963, 1983, 1233, 1445, 1974, 1956, 1691, 1954, 2000, 1469, 1875, 955, 1334, 1116, 1700, 1818, 1790, 1704, 1901, 1072, 1848, 1990, 1724, 1719, 1638, 1311, 1474, 1837, 1801, 1929, 1791, 1317, 1643, 1632, 1813, 1488, 1129, 1998, 1771, 1793, 1074, 1826, 1935, 1462, 1230, 1797, 1878, 1751, 1993, 1437, 1967, 1844, 1438, 1969, 1175, 1823, 1124, 1922, 154, 936, 1117, 1145, 1308, 1320, 1767, 1850, 1809, 1350, 1820, 1082, 1597, 1913, 1766, 1701, 1294, 1556, 2006, 1480, 1953, 1104, 1861, 1966, 1248, 1671, 1955, 1863, 1202, 1356, 1842, 2010, 1288, 1067, 1576, 1295, 1760, 1888, 1639, 1282, 1633, 1619 )
  val entriesSet = entries.toSet

  sealed trait Sol {
    // def finalProd(entriesToMultiply: List[Int]): Int
    def finalProd(entriesFunction: (List[Int], Set[Int]) => List[Int], entries: List[Int], entriesSet: Set[Int]): Int
  }
  // We can use Sets in order to determine what the correct values are for this solution.
  // Since sets have a constant insertion and retrieval time, we are able to use this as a lookup table.
  // We can input all of the entries into the Set and then simply iterate through all of them and see
  // if the set contains another value that would sum to 2020, or contains another 2 values that would sum to 2020.
  // From here we can find the product of the values and we have found the solution.
  // This should be able to increase the efficiency of what we are looking up by a factor of n.
  // Meaning, that if we would like to find 2 entries that sum to 2020, then we should be able to do that in O(n) time,
  // And if we would like to find 4 entries that sum to 2020, then we should be able to do that in O(n^2) time.
  // So on and so forth.
  // The solution below is for 2 entries.
  object partOne extends Sol {
    override def finalProd(entriesFunction: (List[Int], Set[Int]) => List[Int], entries: List[Int], entriesSet: Set[Int]): Int = {
      val entriesToMult = entriesFunction(entries, entriesSet)
      entriesToMult.reduce((total, current) => total * current)
      // We can convert the list of entries to a set using the .toSet function
    }

    def getList: (List[Int], Set[Int]) => List[Int] = (entries, entriesSet) => {
      // We can use for comprehension to find a List in which each of the elements 
      // are the elements that sum to 2020
      for {
        entry <- entries
        if (entriesSet.contains(2020 - entry))
      } yield entry
    }
  }

  // The solution below is for 3 entries
  object partTwo extends Sol {
    override def finalProd(entriesFunction: (List[Int], Set[Int]) => List[Int], entries: List[Int], entriesSet: Set[Int]): Int = {
      val entriesToMult = entriesFunction(entries, entriesSet) 
      entriesToMult.reduce((total, current) => total * current)
    }

    // Not efficient, or functional, but works
    def createList: (List[Int], Set[Int]) => List[Int] = (entries, entriesSet) => {
      var finalArray = new Array[Int](3)
      for (element <- entries) {
        val newResult = 2020 - element
        for (anotherElement <- entries) {
          if (entriesSet.contains(newResult - anotherElement)) {
            val finalElement = newResult - anotherElement
            finalArray :+= element 
            finalArray :+= anotherElement 
            finalArray :+= finalElement
          }
        }
      } 
      // Quick and dirty way to get rid of duplicates in the list and gets rid of the 0 in the 0th index
      // https://stackoverflow.com/questions/44743653/how-to-remove-duplicates-from-an-array-in-scala
      val finalList = finalArray.toSet.toList.drop(1)
      finalList
    }
  }

  def main(args: Array[String]): Unit = {

    val partOneAnswer = partOne.finalProd(partOne.getList, entries, entriesSet)
    val partTwoAnswer = partTwo.finalProd(partTwo.createList, entries, entriesSet)
    println(s"Day 1, Part 1: ${partOneAnswer}")
    println(s"Day 2, Part 2: ${partTwoAnswer}")
    // println(finalProd(getList(entries, entriesSet)))
  }
}
