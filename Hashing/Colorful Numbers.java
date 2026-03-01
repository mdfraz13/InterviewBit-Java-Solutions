/**
 * Problem: Check if a number is colorful.
 * A number is colorful if product of every contiguous subsequence of digits is unique.
 * Algorithm: Generate all contiguous subsequences and check if all products are unique.
 * Time Complexity: O(n²) where n is number of digits
 * Space Complexity: O(n²) for storing all products in HashSet
 */
public class Solution {
  /**
   * Determines if a number is colorful.
   * A number is colorful if all products of contiguous sequences of digits are unique.
   * 
   * @param A the integer to check
   * @return 1 if colorful, 0 if not
   * 
   * Example:
   *   23245: Products are 2, 23, 232, 2324, 3, 32, 324, 2, 24, 4
   *   All unique -> 1 (colorful)
   *   
   *   1 -> 1 (single digit is colorful)
   *   11 -> 0 (product of [1,1] creates duplicate 1's)
   */
  public int colorful(int A) {
    // Step 1: Create HashSet to track all products seen so far
    // If we encounter duplicate product, number is not colorful
    Set<Integer> set = new HashSet<>();
    
    // Step 2: Convert integer to string to easily access individual digits
    String s = String.valueOf(A);
    
    // Step 3: Iterate through all starting positions for contiguous sequences
    for (int i = 0; i < s.length(); i++) {
      // Step 3a: Initialize product to 1 for each starting position
      int prod = 1;
      
      // Step 3b: Calculate products of all subsequences starting at position i
      for (int j = i; j < s.length(); j++) {
        // Step 3c: Multiply current digit to running product
        // Character.getNumericValue converts '2' to 2
        prod *= Character.getNumericValue(s.charAt(j));
        
        // Step 3d: Check if this product already exists
        // If yes, duplicate found -> number is not colorful
        if (set.contains(prod)) {
          return 0;  // Not colorful
        }
        
        // Step 3e: Add unique product to set
        set.add(prod);
      }
    }
    
    // Step 4: All products are unique -> number is colorful
    return 1;
  }
}

