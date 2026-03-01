/**
 * Problem: Check if array contains two distinct elements with difference B (two-pointer sorted array).
 * Algorithm: Two-pointer technique on the original array (presumably sorted).
 * Time Complexity: O(n) assuming array is sorted
 * Space Complexity: O(1)
 */
public class Solution {
    /**
     * Checks if there exist two distinct elements with difference B.
     * 
     * @param A the input ArrayList of integers (should be sorted)
     * @param B the target difference
     * @return 1 if pair found, 0 if not
     * 
     * Example:
     *   A = [1, 3, 5, 6], B = 2
     *   Output: 1 (e.g., 3 and 5, or 1 and 3)
     */
    public int diffPossible(ArrayList<Integer> A, int B) {
        // Step 1: Initialize two pointers
        int idx1 = 0;  // Left pointer
        int idx2 = 1;  // Right pointer
        int n = A.size();
        
        // Step 2: Use two-pointer technique to find pair with difference B
        while (idx1 < n && idx2 < n) {
            // Step 2a: Calculate current difference
            // Step 2b: Check if indices are different and difference equals target B
            if (idx1 != idx2 && A.get(idx2) - A.get(idx1) == B) {
                return 1;  // Found the pair
            }
            
            // Step 2c: If difference is too small, increase it by moving right pointer forward
            if (A.get(idx2) - A.get(idx1) < B) {
                idx2++;
            }
            // Step 2d: If difference is too large, decrease it by moving left pointer forward
            else {
                idx1++;
            }
        }
        
        // Step 3: No pair with difference B found
        return 0;
    }
}

