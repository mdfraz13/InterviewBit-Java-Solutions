/**
 * Problem: Group all anagrams together from a list of strings.
 * Algorithm: Use sorted characters as key in HashMap to group anagrams.
 * Time Complexity: O(n * k log k) where n is number of strings, k is average length
 * Space Complexity: O(n * k) for storing all strings in HashMap
 */
public class Solution {
  // DO NOT MODIFY THE LIST. IT IS READ ONLY
  /**
   * Groups anagrams together from a list of strings.
   * 
   * @param A the input list of strings
   * @return ArrayList of ArrayList containing grouped anagrams with 1-based indices
   * 
   * Example:
   *   A = ["listen", "silent", "hello", "world"]
   *   Output: [[1, 2], [3], [4]] (indices of anagrams grouped)
   */
  public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
    // Step 1: Create a HashMap where key is sorted characters and value is list of indices
    Map<String, ArrayList<Integer>> map = new HashMap<>();
    
    // Step 2: Iterate through all strings in the input list
    for (int i = 0; i < A.size(); i++) {
      // Step 2a: Get the sorted key for current string
      // Anagrams will have the same sorted characters
      // Example: "listen" and "silent" both become "eilnst"
      String sortedKey = getSortedKey(A.get(i));
      
      // Step 2b: Add 1-based index to the list of indices for this sorted key
      // computeIfAbsent: if key doesn't exist, create new ArrayList
      // Then add the current 1-based index (i+1)
      map.computeIfAbsent(sortedKey, k -> new ArrayList<>()).add(i + 1);
    }
    
    // Step 3: Return all grouped indices as ArrayList of ArrayList
    return new ArrayList<>(map.values());
  }

  /**
   * Helper method to get sorted key for a string.
   * This key is the same for all anagrams.
   * 
   * @param s the input string
   * @return the string with all characters sorted
   * 
   * Example:
   *   "listen" -> "eilnst"
   *   "silent" -> "eilnst"
   */
  private String getSortedKey(String s) {
    // Step 1: Convert string to char array
    char[] ch = s.toCharArray();
    
    // Step 2: Sort the characters alphabetically
    Arrays.sort(ch);
    
    // Step 3: Convert back to string and return
    return String.valueOf(ch);
  }
}

