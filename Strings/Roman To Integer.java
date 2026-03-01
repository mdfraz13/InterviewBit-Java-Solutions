/**
 * Problem: Convert a Roman numeral string to its integer equivalent.
 * Roman numerals: I=1, V=5, X=10, L=50, C=100, D=500, M=1000
 * Special cases: IV=4, IX=9, XL=40, XC=90, CD=400, CM=900
 * Algorithm: Use HashMap to map Roman numerals to values, process from left to right.
 * Time Complexity: O(n) where n is length of Roman string
 * Space Complexity: O(1) constant space for the map
 */
public class Solution {
  /**
   * Converts a Roman numeral string to an integer.
   * 
   * @param A the Roman numeral string
   * @return the integer representation
   * 
   * Example:
   *   "III" -> 3
   *   "IV" -> 4
   *   "MCMXC" -> 1990
   */
  public int romanToInt(String A) {
    // Step 1: Define arrays for Roman numeral symbols and their values
    // Include special two-character Roman numerals (IV, IX, etc.)
    String[] keys = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    int[] values = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    
    // Step 2: Create HashMap to map Roman numeral to integer value
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < keys.length; i++) {
      map.put(keys[i], values[i]);
    }
    
    // Step 3: Initialize variables
    int idx = 0;
    int n = A.length();
    int sum = 0;
    
    // Step 4: Process Roman numeral string from left to right
    while (idx < n) {
      // Step 4a: Check if next two characters form a special Roman numeral
      // (e.g., IV, IX, XL, XC, CD, CM)
      if (idx + 1 < n && map.containsKey(A.substring(idx, idx + 2))) {
        // Add two-character value and skip 2 positions
        sum += map.get(A.substring(idx, idx + 2));
        idx++;  // Will be incremented again at the end of loop
      }
      else {
        // Single character Roman numeral
        sum += map.get(String.valueOf(A.charAt(idx)));
      }
      idx++;  // Move to next position
    }
    
    // Step 5: Return the total sum
    return sum;
  }
}

