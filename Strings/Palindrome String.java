/**
 * Problem: Check if a string is a palindrome considering only alphanumeric characters,
 * ignoring case and spaces/special characters.
 * Algorithm: Two-pointer approach from both ends comparing characters.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class Solution {
  /**
   * Determines if a string is a palindrome ignoring non-alphanumeric characters and case.
   * 
   * @param A the input string to check
   * @return 1 if palindrome, 0 if not
   * 
   * Example:
   *   "A man, a plan, a canal: Panama" -> 1 (palindrome)
   *   "hello" -> 0 (not palindrome)
   */
  public int isPalindrome(String A) {
    // Step 1: Initialize two pointers at the start and end of the string
    int start = 0;
    int end = A.length() - 1;
    
    // Step 2: Compare characters from both ends moving towards center
    while (start <= end) {
      // Step 2a: Check if both characters are alphanumeric (letters or digits)
      if (Character.isLetterOrDigit(A.charAt(start)) && Character.isLetterOrDigit(A.charAt(end))) {
        // Step 2b: Convert both characters to lowercase for comparison
        // (keeps digits as-is since case doesn't apply to them)
        char c1 = Character.isLetter(A.charAt(start)) ? Character.toLowerCase(A.charAt(start)) : A.charAt(start);
        char c2 = Character.isLetter(A.charAt(end)) ? Character.toLowerCase(A.charAt(end)) : A.charAt(end);
        
        // Step 2c: If characters don't match, not a palindrome
        if (c1 != c2) {
          return 0;
        }
        
        // Step 2d: Move both pointers inward
        start++;
        end--;
      }
      else {
        // Step 2e: Skip non-alphanumeric characters from the left
        if (!Character.isLetterOrDigit(A.charAt(start))) {
          start++;
        }
        
        // Step 2f: Skip non-alphanumeric characters from the right
        if (!Character.isLetterOrDigit(A.charAt(end))) {
          end--;
        }
      }
    }
    
    // Step 3: If all valid characters matched, it's a palindrome
    return 1;
  }
}

