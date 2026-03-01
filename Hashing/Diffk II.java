/**
 * Problem: Check if there exist two elements in array with difference K.
 * Algorithm: Use HashSet - for each element, check if (num + K) or (num - K) exists.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    /**
     * Determines if there exist two distinct elements with difference K.
     * 
     * @param A the input list of integers
     * @param B the difference K to find
     * @return 1 if pair exists, 0 if not
     * 
     * Example:
     *   A = [1, 3, 5, 7], B = 2
     *   Output: 1 (1 and 3 have difference 2)
     */
    public int diffPossible(final List<Integer> A, int B) {
        // Step 1: Handle edge case - need at least 2 elements
        if (A.size() <= 1) {
            return 0;
        }
        
        // Step 2: Create HashSet to store elements we've seen
        Set<Integer> set = new HashSet<>();
        
        // Step 3: Iterate through array
        for (int num : A) {
            // Step 3a: Check if (num + B) exists in set
            // This means we have two elements with difference B
            if (set.contains(num + B)) {
                return 1;  // Pair found
            }
            
            // Step 3b: Check if (num - B) exists in set
            // This also means we have two elements with difference B
            if (set.contains(num - B)) {
                return 1;  // Pair found
            }
            
            // Step 3c: Add current element to set for future comparisons
            set.add(num);
        }
        
        // Step 4: No pair with difference B found
        return 0;
    }
}
