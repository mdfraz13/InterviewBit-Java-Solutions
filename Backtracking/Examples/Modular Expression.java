/**
 * Problem: Calculate (a^b) % c using modular exponentiation with recursion.
 * Algorithm: Divide-and-conquer using fast exponentiation - reduces repeated calculations.
 * Time Complexity: O(log b) due to halving the exponent
 * Space Complexity: O(log b) for recursion depth
 */
public class Solution {
	/**
	 * Calculates (a^b) % c using fast modular exponentiation.
	 * Handles overflow and negative modulo correctly.
	 * 
	 * @param a the base
	 * @param b the exponent
	 * @param c the modulo divisor
	 * @return (a^b) % c
	 * 
	 * Example:
	 *   a=2, b=10, c=1000 -> 1024 % 1000 = 24
	 *   a=0, b=5, c=7 -> 0
	 */
	public int Mod(int a, int b, int c) {
	    // Step 1: Base case - if a is 0, result is always 0
	    if(a == 0){
	        return 0;
	    }
	    
	    // Step 2: Base case - if b is 0, result is 1 (a^0 = 1)
	    if(b == 0){
	        return 1;
	    }
	    
	    // Step 3: Declare result variable
	    long y = 0;        
	    
	    // Step 4: Use fast exponentiation - divide exponent by 2
	    if (b % 2 == 0) {
	        // Step 4a: If b is even, compute (a^(b/2))^2
	        // This reduces the problem size significantly
	        y = Mod(a, b / 2, c);
	        
	        // Step 4b: Square the result and apply modulo
	        y = (y * y) % c;
	    } 
	    else {
	        // Step 4c: If b is odd, use a * a^(b-1)
	        // First compute a % c to handle large 'a' values
	        y = a % c;
	        
	        // Step 4d: Multiply with result of a^(b-1) and apply modulo
	        y = (y * Mod(a, b - 1, c)) % c;
	    }
	    
	    // Step 5: Handle negative modulo by adding c if needed
	    // This ensures result is always in range [0, c-1]
	    return (int)((y + c) % c);
	}
}