/**
 * Problem: Merge second sorted array into first array (in-place).
 * Algorithm: Two-pointer approach - insert elements from B into A at correct positions.
 * Time Complexity: O(n * m) in worst case due to array insertions
 * Space Complexity: O(1) in-place modification
 */
public class Solution {
  /**
   * Merges the second sorted array into the first array in-place.
   * 
   * @param a the first sorted array (modified in-place)
   * @param b the second sorted array
   * 
   * Example:
   *   a = [1, 5, 9], b = [2, 3, 8]
   *   After merge: a = [1, 2, 3, 5, 8, 9]
   */
  public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
    // Step 1: Initialize pointers for both arrays
    int idxA = 0;  // Pointer for array a
    int idxB = 0;  // Pointer for array b
    
    // Step 2: Compare elements and insert smaller element from b into a
    while (idxA < a.size() && idxB < b.size()) {
      // Step 2a: Check if current element in b is smaller than current element in a
      if (a.get(idxA) > b.get(idxB)) {
        // Step 2b: Insert element from b at current position in a
        // This shifts all elements at idxA and beyond to the right
        a.add(idxA, b.get(idxB));
        idxB++;
      }
      // Step 2c: Move pointer in a to next position
      idxA++;
    }
    
    // Step 3: Add remaining elements from b to the end of a
    // (if b has elements left, they are all greater than remaining elements in a)
    while (idxB < b.size()) {
      a.add(b.get(idxB++));
    }
  }
}

