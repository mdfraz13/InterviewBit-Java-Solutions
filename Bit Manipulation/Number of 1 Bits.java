/**
 * Problem: Count the number of 1 bits (set bits) in a long integer.
 * Algorithm: Convert to binary string and count '1' characters.
 * Time Complexity: O(log a) where a is the input number
 * Space Complexity: O(log a) for the binary string
 */
public class Solution {
	/**
	 * Counts the number of 1 bits in the binary representation of a number.
	 * 
	 * @param a the long value to count set bits in
	 * @return the count of 1 bits in binary representation
	 */
	public int numSetBits(long a) {
        // Step 1: Convert the long number to its binary string representation
        // Example: 5 -> "101", 7 -> "111"
        String str = Long.toBinaryString(a);
        
        // Step 2: Calculate the number of '1' bits
        // Method: Remove all '1' characters and subtract from total length
        // Example: "101".length() = 3, "101".replace("1", "") = "0" -> length = 1
        // Result: 3 - 1 = 2 (which is correct for binary 101)
        return str.length() - str.replace("1", "").length();
	}
}
