/**
 * Problem: Find intersection (common elements) of two sorted arrays.
 * Algorithm: Two-pointer technique - move pointers to find matching elements.
 * Time Complexity: O(n + m) where n and m are sizes of the two arrays
 * Space Complexity: O(1) if we don't count output array space
 */
public class Solution {
  // DO NOT MODIFY THE LIST. IT IS READ ONLY
  /**
   * Finds common elements between two sorted arrays.
   * 
   * @param A first sorted array
   * @param B second sorted array  
   * @return ArrayList containing all common elements in same order
   * 
   * Example:
   *   A = [1, 2, 2, 3], B = [2, 3, 3, 4]
   *   Output: [2, 3]
   */
  public ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
    // Step 1: Initialize two pointers at the start of both arrays
    int startA = 0;
    int startB = 0;
    
    // Step 2: Create result ArrayList to store intersection elements
    ArrayList<Integer> list = new ArrayList<>();
    
    // Step 3: Traverse both arrays simultaneously using two pointers
    while (startA < A.size() && startB < B.size()) {
      // Step 3a: Compare elements at current pointers
      if (A.get(startA).equals(B.get(startB))) {
        // Step 3b: Elements match - add to result and advance both pointers
        list.add(A.get(startA));
        startA++;
        startB++;
      }
      // Step 3c: Element in A is smaller - advance A's pointer
      // (to find potentially matching element)
      else if (A.get(startA) < B.get(startB)) {
        startA++;
      }
      // Step 3d: Element in B is smaller - advance B's pointer
      else {
        startB++;
      }
    }
    
    // Step 4: Return the intersection result
    return list;
  }
}
