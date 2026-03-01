/**
 * Problem: Find three elements in a sorted array that give the sum closest to target B.
 * Algorithm: Sort array, use three pointers (one fixed, two moving) to find closest sum.
 * Time Complexity: O(n²) - outer loop O(n), inner two-pointer O(n)
 * Space Complexity: O(1) if we don't count sorting space
 */
public class Solution {
  /**
   * Finds three numbers that produce the sum closest to target B.
   * 
   * @param A the input ArrayList of integers
   * @param B the target sum
   * @return the sum of three numbers closest to B
   * 
   * Example:
   *   A = [1, 4, 45, 6, 10, 8], B = 13
   *   Possible triplets: 1+4+6=11, 1+4+8=13, etc.
   *   Output: 13 (exact match)
   */
  public int threeSumClosest(ArrayList<Integer> A, int B) {
    // Step 1: Sort the array to enable two-pointer technique
    Collections.sort(A);
    
    // Step 2: Initialize variables to track closest difference and result sum
    int closest = Integer.MAX_VALUE;  // Track minimum difference from target
    int res = 0;                       // Track the actual sum closest to target
    
    // Step 3: Iterate through array with first pointer
    for (int i = 0; i < A.size() - 2; i++) {
      // Step 3a: Initialize two pointers - one right after i, one at end
      int start = i + 1;
      int end = A.size() - 1;
      
      // Step 3b: Use two-pointer technique to find closest sum with A[i]
      while (start < end) {
        // Step 3c: Calculate current sum of three elements
        int currSum = A.get(i) + A.get(start) + A.get(end);
        
        // Step 3d: Calculate difference from target
        int diff = Math.abs(currSum - B);
        
        // Step 3e: If we found exact match, return immediately
        if (diff == 0) {
          return B;
        }
        
        // Step 3f: Update closest pair if current difference is smaller
        if (diff < closest) {
          closest = diff;
          res = currSum;
        }
        
        // Step 3g: Move pointers to adjust sum
        // If current sum is too small, increase it by moving start forward
        // If current sum is too large, decrease it by moving end backward
        if (currSum <= B) {
          start++;
        }
        else {
          end--;
        }
      }
    }
    
    // Step 4: Return the sum closest to target
    return res;
  }
}

