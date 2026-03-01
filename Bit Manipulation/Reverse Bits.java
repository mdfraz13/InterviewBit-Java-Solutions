/**
 * Problem: Reverse the bits of a 32-bit unsigned integer.
 * Algorithm: Convert to binary string, pad with leading zeros to 32 bits, reverse, and convert back.
 * Time Complexity: O(1) since it's always 32 bits
 * Space Complexity: O(1) constant space
 */
public class Solution {
	/**
	 * Reverses the bits of a long integer (treating it as a 32-bit number).
	 * 
	 * @param a the long value whose bits need to be reversed
	 * @return the value after reversing its 32 bits
	 * 
	 * Example: 
	 *   Input: 1 (binary: 00000000000000000000000000000001)
	 *   Output: 2147483648 (binary: 10000000000000000000000000000000)
	 */
	public long reverse(long a) {
	    // Step 1: Convert the long number to its binary string representation
	    // Example: 1 -> "1"
	    StringBuilder sb = new StringBuilder(Long.toBinaryString(a));
	    
	    // Step 2: Pad with leading zeros to make it exactly 32 bits
	    // Calculate missing zeros: 32 - current length
	    // Example: "1" needs 31 zeros -> "00000000000000000000000000000001"
	    sb.insert(0, String.join("", Collections.nCopies(32-sb.length(), "0")));
	    
	    // Step 3: Reverse the entire 32-bit binary string
	    // Example: "00000000000000000000000000000001" -> "10000000000000000000000000000000"
	    String s = sb.reverse().toString();
	    
	    // Step 4: Convert the reversed binary string back to a long (radix 2 for binary)
	    // Example: "10000000000000000000000000000000" -> 2147483648
	    return Long.parseLong(s, 2);
	}
}
