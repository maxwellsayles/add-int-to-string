// Substitute and reorder.
def addIntToString(x: Int, y: String): String = {
  var xc  = x
  var yc  = y
  var acc = ""
  while (!yc.isEmpty) {
    // Add values in current column.
    val z0 = (xc % 10) + (yc.last.toInt - '0')
    // Update xc and yc.
    xc = (xc / 10) + (z0 / 10)
    yc = yc.dropRight(1)
    // Next character.
    acc = (z0 % 10).toString + acc
  }
  if (xc == 0) acc else xc.toString + acc
}

println(addIntToString(1, "1999999999999999999999999999999"))
println(addIntToString(2, "0000000000000000009999999999999"))
println(addIntToString(3, "0000000000000000000000000000000"))
println(addIntToString(123456789, "0"))
