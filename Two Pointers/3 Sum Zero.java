/**
 * Problem: Find all unique triplets in array that sum to zero.
 * Algorithm: Sort array, then use two-pointer technique for each fixed element.
 * Time Complexity: O(n²) - outer loop O(n), inner two-pointer O(n)
 * Space Complexity: O(1) if we don't count output array space
 */
public class Solution {
    /**
     * Finds all unique triplets that sum to zero.
     * 
     * @param A the input ArrayList of integers
     * @return ArrayList of all unique triplets summing to zero
     * 
     * Example:
     *   A = [-1, 0, 1, 2, -1, -4]
     *   Output: [[-1, -1, 2], [-1, 0, 1]]
     */
    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        // Step 1: Sort the array to enable two-pointer technique
        Collections.sort(A);
        
        // Step 2: Create result ArrayList to store all triplets
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        // Step 3: Fix each element as the first element of triplet
        for (int i = 0; i < A.size() - 2; i++) {
            // Step 3a: Skip duplicate values to avoid duplicate triplets
            if (i > 0 && A.get(i).equals(A.get(i - 1))) {
                continue;
            }
            
            // Step 3b: Calculate target sum for remaining two elements
            // We need: A[i] + A[j] + A[k] = 0
            // Therefore: A[j] + A[k] = -A[i]
            int target = -A.get(i);
            
            // Step 3c: Initialize two pointers for two-sum problem
            int j = i + 1;              // Start from next element
            int k = A.size() - 1;       // Start from end
            
            // Step 3d: Use two-pointer technique to find pairs that sum to target
            while (j < k) {
                // Step 3e: Calculate current sum of two elements
                int currentSum = A.get(j) + A.get(k);
                
                // Step 3f: Check if we found the triplet
                if (currentSum == target) {
                    // Add triplet to result
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(A.get(i));
                    temp.add(A.get(j));
                    temp.add(A.get(k));
                    ans.add(temp);
                    
                    // Move both pointers
                    j++;
                    k--;
                    
                    // Skip duplicate values at j to avoid duplicate triplets
                    while(j < k && A.get(j) == A.get(j - 1)) {
                        j++;
                    }
                    
                    // Skip duplicate values at k to avoid duplicate triplets
                    while(j < k && A.get(k) == A.get(k + 1)) {
                        k--;
                    }
                }
                // If sum is too large, decrease it by moving k left
                else if (currentSum > target) {
                    k--;
                }
                // If sum is too small, increase it by moving j right
                else {
                    j++;
                }
            }
        }
        
        // Step 4: Return all found triplets
        return ans;
    }
}
