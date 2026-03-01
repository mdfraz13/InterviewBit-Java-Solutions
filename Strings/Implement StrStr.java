/**
 * Problem: Find the first occurrence of pattern B in string A (similar to indexOf).
 * Algorithm: Simple substring comparison - check each position in A for match with B.
 * Time Complexity: O(n * m) where n = len(A), m = len(B)
 * Space Complexity: O(1)
 */
public class Solution {
  // DO NOT MODIFY THE LIST. IT IS READ ONLY
  /**
   * Finds the first occurrence of pattern B in string A.
   * 
   * @param A the main string to search in
   * @param B the pattern string to find
   * @return 0-based index of first occurrence, -1 if not found
   * 
   * Example:
   *   A = "hello world", B = "world" -> 6
   *   A = "hello", B = "bye" -> -1
   */
  public int strStr(final String A, final String B) {
    // Step 1: Get lengths of both strings
    int lenA = A.length();
    int lenB = B.length();
    
    // Step 2: If pattern is longer than text, it can't be found
    if (lenB > lenA) {
      return -1;
    }
    
    // Step 3: Check each position in A for a match with B
    // We only need to check up to lenA - lenB positions
    // (after that, there aren't enough characters left to match B)
    for (int i = 0; i <= lenA - lenB; i++) {
      // Step 3a: Extract substring of length lenB starting at position i
      // Step 3b: Compare with pattern B
      if (A.substring(i, i + lenB).equals(B)) {
        // Step 3c: Pattern found, return starting index
        return i;
      }
    }
    
    // Step 4: Pattern not found anywhere in A
    return -1;
  }
}
