/**
 * Problem: Add two binary numbers represented as strings.
 * Algorithm: Process from right to left, handling carry at each position.
 * Time Complexity: O(max(len(A), len(B)))
 * Space Complexity: O(max(len(A), len(B))) for result
 */
public class Solution {
  /**
   * Adds two binary numbers represented as strings.
   * 
   * @param A first binary string
   * @param B second binary string
   * @return the binary sum as a string
   * 
   * Example:
   *   A = "11", B = "1" -> "100" (3 + 1 = 4)
   *   A = "10", B = "10" -> "100" (2 + 2 = 4)
   */
  public String addBinary(String A, String B) {
    // Step 1: Initialize pointers to the rightmost characters of both strings
    int idx1 = A.length() - 1;
    int idx2 = B.length() - 1;
    
    // Step 2: Initialize carry to 0
    int carry = 0;
    
    // Step 3: Create StringBuilder to build result (will be reversed)
    StringBuilder sb = new StringBuilder();
    
    // Step 4: Process both strings from right to left
    while (idx1 >= 0 || idx2 >= 0 || carry > 0) {
      // Step 4a: Initialize value with carry
      int val = carry;
      
      // Step 4b: Add digit from A if available
      if (idx1 >= 0) {
        val += Character.getNumericValue(A.charAt(idx1--));
      }
      
      // Step 4c: Add digit from B if available
      if (idx2 >= 0) {
        val += Character.getNumericValue(B.charAt(idx2--));
      }
      
      // Step 4d: Calculate new carry (val > 1 means carry = 1)
      carry = val > 1 ? 1 : 0;
      
      // Step 4e: Calculate digit for this position
      // In binary: val=0->0, val=1->1, val=2->0 (with carry), val=3->1 (with carry)
      val = val > 1 ? (val == 2 ? 0 : 1) : val;
      
      // Step 4f: Append to StringBuilder (reversed order for now)
      sb.append(val);
    }
    
    // Step 5: Reverse the result and return (because we built it backwards)
    return sb.reverse().toString();
  }
}
