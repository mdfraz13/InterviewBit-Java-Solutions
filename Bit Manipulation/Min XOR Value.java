/**
 * Problem: Find the minimum XOR of any two elements in an array.
 * Algorithm: Sort the array, then XOR adjacent elements. 
 * Adjacent elements in sorted array are more likely to have same bits, resulting in smaller XOR.
 * Time Complexity: O(n log n) due to sorting
 * Space Complexity: O(1)
 */
public class Solution {
    /**
     * Finds the minimum XOR value between any two elements in the array.
     * 
     * @param A the input ArrayList of integers
     * @return the minimum XOR value
     * 
     * Example:
     *   A = [5, 2, 3, 8, 12]
     *   After sorting: [2, 3, 5, 8, 12]
     *   Check: 2^3=1, 3^5=6, 5^8=13, 8^12=4
     *   Output: 1
     */
    public int findMinXor(ArrayList<Integer> A) {
        // Step 1: Sort the array
        // Key insight: adjacent elements in sorted array are more likely to have same bits
        // This increases chances of smaller XOR values
        Collections.sort(A);
        
        // Step 2: Initialize minimum XOR to maximum possible value
        int minXor = Integer.MAX_VALUE;
        
        // Step 3: Check XOR of all adjacent pairs (adjacent in sorted order)
        // Only adjacent elements need to be checked because:
        // If A < B < C, then A^C >= min(A^B, B^C) in most cases
        for (int i = 0; i < A.size() - 1; i++) {
            // Step 3a: Calculate XOR of current and next element
            int currentXor = A.get(i) ^ A.get(i + 1);
            
            // Step 3b: Update minimum if current XOR is smaller
            minXor = Math.min(minXor, currentXor);
        }
        
        // Step 4: Return the minimum XOR found
        return minXor;
    }
}
