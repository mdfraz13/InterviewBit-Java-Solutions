/**
 * Problem: Find the single number that appears once while all other numbers appear twice.
 * Algorithm: XOR (Exclusive OR) - XOR of two same numbers is 0, XOR of any number with 0 is the number itself.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public static int singleNumber(final List<Integer> A) {
        // Step 1: Initialize num with the first element
        int num = A.get(0);
        
        // Step 2: Iterate through all remaining elements starting from index 1
        for (int i=1; i<A.size(); i++) {
            // Step 2a: XOR current number with num
            // - If A[i] appears twice, one will cancel out the other
            // - If A[i] is the single number, it will remain
            // Example: 5 ^ 5 = 0, 5 ^ 0 = 5, 3 ^ 3 ^ 5 = 0 ^ 5 = 5
            num ^= A.get(i);
        }
        
        // Step 3: Return the single number (all pairs have been XORed to 0)
        return num;
    }
}
