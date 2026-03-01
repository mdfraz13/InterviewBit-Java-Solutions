/**
 * Problem: Find the single number that appears once, where all other numbers appear 3 times.
 * Algorithm: Use HashMap to count occurrences and find element with count = 1.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 * Note: Can be optimized to O(1) space using bit manipulation with bit positions,
 * but this approach is more intuitive.
 */
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    /**
     * Finds the single number that appears once while all others appear 3 times.
     * 
     * @param A the input list of integers
     * @return the element that appears exactly once
     * 
     * Example:
     *   A = [1, 1, 1, 2, 2, 2, 5]
     *   Output: 5 (appears once, others appear 3 times)
     */
    public static int singleNumber(final List<Integer> A) {
        // Step 1: Create HashMap to store frequency count of each element
        Map<Integer, Integer> map = new HashMap<>();

        // Step 2: Iterate through all elements and count their occurrences
        for (int num : A) {
            // Step 2a: Put element with count 1 if not exists, or increment by 1
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 3: Initialize result variable
        int ans = -1;

        // Step 4: Find the element with frequency count of 1
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // Step 4a: Check if this element appears exactly once
            if (entry.getValue() == 1) {
                // Step 4b: Store the element and break
                ans = entry.getKey();
                break;
            }
        }

        // Step 5: Return the single occurring element
        return ans;
    }
}
