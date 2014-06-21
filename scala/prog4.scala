// Recursive.  `dropRight` is inefficient.
def addIntToString(x: Int, y: String, acc: String = ""): String =
  y match {
    case "" =>
      if (x == 0) acc else x.toString + acc
    case _ =>
      // Add values in current column.
      val z0 = (x % 10) + (y.last.toInt - '0')
      // Update xc and yc.
      val x1 = (x / 10) + (z0 / 10)
      val y1 = y.dropRight(1)
      // Next character.
      val acc1 = (z0 % 10).toString + acc
      addIntToString(x1, y1, acc1)
  }

println(addIntToString(1, "1999999999999999999999999999999"))
println(addIntToString(2, "0000000000000000009999999999999"))
println(addIntToString(3, "0000000000000000000000000000000"))
println(addIntToString(123456789, "0"))
