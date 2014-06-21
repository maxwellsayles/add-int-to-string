// Left fold over a continuation.
def addIntToString(x: Int, y: String): String = {
  def step(k: Int => List[Int], y0: Int) = (xc: Int) => {
    // Add values in current column.
    val z0 = (xc % 10) + y0
    // Update x.
    val x1 = (xc / 10) + (z0 / 10)
    // Result of current step.
    (z0 % 10) :: k(x1)
  }

  // Last continuation, but first value of fold.
  def acc0(xc: Int): List[Int] = if (xc == 0) List() else List(xc)

  val digits = y.toList.map(_ - '0')
  val addY = digits.foldLeft(acc0 _)(step)
  addY(x).reverse.mkString
}

println(addIntToString(1, "1999999999999999999999999999999"))
println(addIntToString(2, "0000000000000000009999999999999"))
println(addIntToString(3, "0000000000000000000000000000000"))
println(addIntToString(123456789, "0"))

