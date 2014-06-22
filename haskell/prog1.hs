import Data.Char (digitToInt, intToDigit)

add :: String -> Int -> String
add x y = add' (reverse x) y ""

add' [] 0 acc = acc
add' [] y acc = show y ++ acc
add' (x:xs) y acc =
  let z = digitToInt x `mod` 10 + y `mod` 10
      y' = y `div` 10 + z `div` 10
      acc' = intToDigit (z `mod` 10) : acc
  in  add' xs y' acc'
