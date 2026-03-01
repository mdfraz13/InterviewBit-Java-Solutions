/**
 * Problem: Partition a string into all possible ways such that each partition is a palindrome.
 * Algorithm: Backtracking - for each position, try all substrings and check if palindrome.
 * Time Complexity: O(n * 2^n) where n is string length
 * Space Complexity: O(n) for recursion depth
 */
public class Solution {
    /**
     * Partitions a string into all possible palindrome partitions.
     * 
     * @param a the input string
     * @return ArrayList of all ways to partition string into palindromes
     * 
     * Example:
     *   a = "aba"
     *   Output: [["a","b","a"], ["aba"]]
     */
    public ArrayList<ArrayList<String>> partition(String a) {
        // Step 1: Create result list
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        
        // Step 2: Start backtracking from index 0
        helper(ans, new ArrayList<String>(), a, 0);
        
        // Step 3: Return all palindrome partitions
        return ans;
    }
 
    /**
     * Backtracking helper to find all palindrome partitions.
     * 
     * @param ans the result list of all partitions
     * @param temp the current partition being built
     * @param a the input string
     * @param idx the current starting index in string
     */
    private void helper(ArrayList<ArrayList<String>> ans, ArrayList<String> temp, String a, int idx) {
        // Step 1: If reached end of string, we have a complete partition
        if (idx == a.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        // Step 2: Try all possible substrings starting from idx
        for (int i = idx; i < a.length(); i++) {
            // Step 2a: Extract substring from idx to i (inclusive)
            String sb = a.substring(idx, i + 1);
            
            // Step 2b: Check if substring is a palindrome
            if (isPalindrome(sb)) {
                // Step 2c: Choose - add palindrome substring to current partition
                temp.add(sb);
                
                // Step 2d: Explore - recurse from next position after this substring
                helper(ans, temp, a, i + 1);
                
                // Step 2e: Un-choose - backtrack by removing the substring
                temp.remove(temp.size() - 1);
            }
        }
    }
 
    /**
     * Helper method to check if a string is a palindrome.
     * 
     * @param s the string to check
     * @return true if palindrome, false otherwise
     */
    private boolean isPalindrome(String s) {
        // Reverse string and check if equals original
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}
