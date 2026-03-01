/**
 * Problem: Find the longest common prefix among all strings in the list.
 * Algorithm: Find shortest string (limiting factor), then compare all strings character by character.
 * Time Complexity: O(n * m) where n is number of strings, m is length of shortest string
 * Space Complexity: O(m) for StringBuilder storing prefix
 */
public class Solution {
  /**
   * Finds the longest common prefix of all strings in the list.
   * 
   * @param A the ArrayList of strings
   * @return the longest common prefix, empty string if no common prefix
   * 
   * Example:
   *   A = ["flower", "flow", "flight"]
   *   Output: "fl"
   *   
   *   A = ["dog", "racecar", "car"]
   *   Output: "" (no common prefix)
   */
  public String longestCommonPrefix(ArrayList<String> A) {
    // Step 1: Handle empty list
    if (A.size() == 0) {
      return "";
    }
    
    // Step 2: Find the shortest string in the list
    // The common prefix can't be longer than the shortest string
    int minLength = Integer.MAX_VALUE;
    int minLengthIdx = 0;
    for (int i = 0; i < A.size(); i++) {
      if (A.get(i).length() < minLength) {
        minLength = A.get(i).length();
        minLengthIdx = i;
      }
    }
    
    // Step 3: Use the shortest string as the reference
    String targetStr = A.get(minLengthIdx);
    
    // Step 4: Build StringBuilder to store the common prefix
    StringBuilder sb = new StringBuilder();
    
    // Step 5: Compare character at each position across all strings
    for (int i = 0; i < targetStr.length(); i++) {
      boolean mismatch = false;
      
      // Step 5a: Check if character at position i is same in all strings
      for (String str : A) {
        if (str.charAt(i) != targetStr.charAt(i)) {
          mismatch = true;
          break;
        }
      }
      
      // Step 5b: If any mismatch found, stop (no point checking further)
      if (mismatch) {
        break;
      }
      
      // Step 5c: Character matches in all strings, add to prefix
      sb.append(targetStr.charAt(i));
    }
    
    // Step 6: Return the common prefix
    return sb.length() == 0 ? "" : sb.toString();
  }
}

