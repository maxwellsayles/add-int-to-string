// Simplest imperative version
def addIntToString(x: Int, y: String): String = {
  var carry = 0
  var xc    = x
  var yc    = y
  var acc   = ""
  while (!yc.isEmpty) {
    // Rightmost digits.
    val x0 = xc % 10
    val y0 = yc.last.toInt - '0'
    // Add values in current column.
    val z0 = x0 + y0 + carry
    // Next character.
    acc = (z0 % 10).toString + acc
    // Update carry.
    carry = z0 / 10
    // Update xc and yc.
    xc = xc / 10
    yc = yc.dropRight(1)
  }
  val last = (xc + carry).toString
  if (last == "0") acc else last + acc
}

println(addIntToString(1, "1999999999999999999999999999999"))
println(addIntToString(2, "0000000000000000009999999999999"))
println(addIntToString(3, "0000000000000000000000000000000"))
println(addIntToString(123456789, "0"))
