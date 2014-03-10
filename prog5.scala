// Right fold.  Not tail recursive.
def addIntToString(x: Int, y: String): String = {
  def step(y0: Int, p: (Int, String)): (Int, String) = {
    val (xc, acc) = p
    // Add values in current column.
    val z0 = (xc % 10) + y0
    // Update x.
    val x1 = (xc / 10) + (z0 / 10)
    // Setup for next step.
    val acc1 = (z0 % 10).toString + acc
    (x1, acc1)
  }

  val acc0 = (x, "")
  val digits = y.toList.map(_ - '0')
  val (xc, acc) = digits.foldRight(acc0)(step)
  if (xc == 0) acc else xc.toString + acc
}

println(addIntToString(1, "1999999999999999999999999999999"))
println(addIntToString(2, "0000000000000000009999999999999"))
println(addIntToString(3, "0000000000000000000000000000000"))
println(addIntToString(123456789, "0"))
