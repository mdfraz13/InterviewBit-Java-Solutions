/**
 * Problem: Remove duplicates from a sorted array in-place.
 * Keep only one instance of each unique element.
 * Algorithm: Two-pointer technique - one for position, one for scanning.
 * Time Complexity: O(n) single pass
 * Space Complexity: O(1) in-place modification
 */
public class Solution {
  /**
   * Removes duplicates from sorted array in-place.
   * Returns the count of unique elements. Array is modified such that 
   * first k elements contain unique values in sorted order.
   * 
   * @param a the sorted ArrayList of integers
   * @return the count of unique elements
   * 
   * Example:
   *   a = [1, 1, 2, 2, 3]
   *   After: [1, 2, 3, _, _] (first 3 elements are unique)
   *   Output: 3
   */
  public int removeDuplicates(ArrayList<Integer> a) {
    // Step 1: Initialize two pointers
    // start: position to place next unique element
    // end: pointer to scan the array
    int start = 0;
    int end = 0;
    int n = a.size();
    
    // Step 2: Iterate through entire array
    while (end < n) {
      // Step 2a: Store current unique number
      int num = a.get(end);
      
      // Step 2b: Skip all duplicate occurrences of this number
      // Move end pointer past all consecutive occurrences of 'num'
      while (end < n && a.get(end) == num) {
        end++;
      }
      
      // Step 2c: Place the unique number at start position
      a.set(start++, num);
    }
    
    // Step 3: Return count of unique elements
    // start represents the index after last unique element
    return start;
  }
}

