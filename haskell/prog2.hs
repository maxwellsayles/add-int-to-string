import Data.Char (digitToInt, intToDigit)

add :: Int -> String -> String
add x y =
    let (x', res) = foldr step (x, "") y
    in  if x' == 0 then res else show x' ++ res

step y (x, acc) = 
     let z = x `mod` 10 + (digitToInt y) `mod` 10
         x' = x `div` 10 + z `div` 10
	 acc' = intToDigit (z `mod` 10) : acc
     in  x' `seq` (x', acc')