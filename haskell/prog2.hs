import Data.Char (digitToInt, intToDigit)

add :: String -> Int -> String
add x y =
  let (y', res) = foldr step (y, "") x
  in  if y' == 0 then res else show y' ++ res

step x (y, acc) = 
  let z = digitToInt x `mod` 10 + y `mod` 10
      y' = y `div` 10 + z `div` 10
      acc' = intToDigit (z `mod` 10) : acc
  in  y' `seq` (y', acc')
