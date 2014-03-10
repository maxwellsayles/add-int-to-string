// Remove 'carry' and use a linked list.
def addIntToString(x: Int, y: String): String = {
  var xc  = x
  var yc  = y
  var acc = ""
  while (!yc.isEmpty) {
    // Rightmost digits.
    val x0 = xc % 10
    val y0 = yc.last.toInt - '0'
    // Add values in current column.
    val z0 = x0 + y0
    // Next character.
    acc = (z0 % 10).toString + acc
    // Update carry.
    val carry = z0 / 10
    // Update xc and yc.
    xc = (xc / 10) + carry
    yc = yc.dropRight(1)
  }
  if (xc == 0) acc else xc.toString + acc
}

println(addIntToString(1, "1999999999999999999999999999999"))
println(addIntToString(2, "0000000000000000009999999999999"))
println(addIntToString(3, "0000000000000000000000000000000"))
println(addIntToString(123456789, "0"))
