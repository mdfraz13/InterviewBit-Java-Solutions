/**
 * Problem: Find the length of the last word in a string (words separated by spaces).
 * Algorithm: Start from end, skip trailing spaces, then count until next space or start.
 * Time Complexity: O(n) where n is length of string
 * Space Complexity: O(1)
 */
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
  /**
   * Returns the length of the last word in a string.
   * A word is a sequence of non-space characters.
   * 
   * @param A the input string
   * @return the length of the last word
   * 
   * Example:
   *   "hello world" -> 5
   *   "hello world  " -> 5 (trailing spaces ignored)
   *   "world" -> 5
   */
  public int lengthOfLastWord(final String A) {
    // Step 1: Initialize index to last character position
    int idx = A.length() - 1;
    
    // Step 2: Skip trailing spaces from the end
    // Move backwards while character is a space
    while (idx >= 0 && A.charAt(idx) == ' ') {
      idx--;
    }
    
    // Step 3: Count characters in the last word
    int count = 0;
    // Continue backwards while character is not a space and haven't reached start
    while (idx >= 0 && A.charAt(idx) != ' ') {
      idx--;          // Move to previous character
      count++;        // Increment character count
    }
    
    // Step 4: Return the count of characters in last word
    return count;
  }
}

