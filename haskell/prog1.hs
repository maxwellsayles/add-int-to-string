import Data.Char (digitToInt, intToDigit)

add :: Int -> String -> String
add x y = add' x (reverse y) ""

add' 0 [] acc = acc
add' x [] acc = show x ++ acc
add' x (y:ys) acc =
     let z = x `mod` 10 + (digitToInt y) `mod` 10
         x' = x `div` 10 + z `div` 10
	 acc' = intToDigit (z `mod` 10) : acc
     in  add' x' ys acc'