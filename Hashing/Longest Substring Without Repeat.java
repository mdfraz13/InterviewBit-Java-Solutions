/**
 * Problem: Find the length of the longest substring without repeating characters.
 * Algorithm: Sliding window with HashMap - maintain window of unique characters.
 * Time Complexity: O(n) where n is length of string (each character visited at most twice)
 * Space Complexity: O(min(n, m)) where m is character set size
 */
public class Solution {
  /**
   * Finds the length of the longest substring without repeating characters.
   * 
   * @param A the input string
   * @return the length of longest substring with all unique characters
   * 
   * Example:
   *   "abcabcbb" -> 3 ("abc" is the longest)
   *   "bbbbb" -> 1 ("b" is the longest)
   *   "pwwkew" -> 3 ("wke" is the longest)
   */
  public int lengthOfLongestSubstring(String A) {
    // Step 1: Initialize variables for tracking maximum length and window
    int maxLength = 0;      // Track maximum length found
    int start = 0;          // Left pointer of sliding window
    int end = 0;            // Right pointer of sliding window
    int n = A.length();
    
    // Step 2: Create HashMap to store character -> frequency mapping
    Map<Character, Integer> map = new HashMap<>();
    
    // Step 3: Use sliding window to find longest substring
    while (end < n) {
      // Step 3a: Get current character at end pointer
      char c = A.charAt(end);
      
      // Step 3b: Add character to map and increment its frequency
      map.put(c, map.getOrDefault(c, 0) + 1);
      
      // Step 3c: If character appears more than once, shrink window from left
      while (map.get(c) > 1) {
        // Remove leftmost character from window
        map.put(A.charAt(start), map.get(A.charAt(start)) - 1);
        start++;
      }
      
      // Step 3d: Expand window by moving end pointer
      end++;
      
      // Step 3e: Update maximum length with current window size
      maxLength = Math.max(maxLength, end - start);
    }
    
    // Step 4: Return the maximum length found
    return maxLength;
  }
}
