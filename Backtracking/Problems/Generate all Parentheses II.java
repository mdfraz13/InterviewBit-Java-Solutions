/**
 * Problem: Generate all valid combinations of n pairs of parentheses.
 * Algorithm: Backtracking - build strings with balanced parentheses using left/right counts.
 * Time Complexity: O(4^n / sqrt(n)) - Catalan number complexity
 * Space Complexity: O(n) for recursion depth
 */
public class Solution {
    /**
     * Generates all valid combinations of n pairs of parentheses.
     * 
     * @param A the number of pairs n
     * @return sorted ArrayList of all valid parentheses combinations
     * 
     * Example:
     *   A = 2
     *   Output: ["(())", "()()"]
     */
    public ArrayList<String> generateParenthesis(int A) {
        // Step 1: Use HashSet to avoid duplicates during generation
        Set<String> set = new HashSet<>();
        
        // Step 2: Start backtracking with 0 left/right parentheses used
        helper(0, 0, A, new StringBuilder(), set);
        
        // Step 3: Convert set to ArrayList and sort
        ArrayList<String> ans = new ArrayList<>(set);
        Collections.sort(ans);
        
        // Step 4: Return sorted list
        return ans;
    }

    /**
     * Backtracking helper to generate valid parentheses.
     * 
     * @param left the count of '(' used
     * @param right the count of ')' used
     * @param n the total number of pairs needed
     * @param sb the current string being built
     * @param set the set of valid combinations
     */
    private void helper(int left, int right, int n, StringBuilder sb, Set<String> set) {
        // Step 1: If more than n open or close parentheses, invalid path
        if (left > n || right > n) {
            return;
        }
        
        // Step 2: Invalid if more closing than opening parentheses
        if (left < right) {
            return;
        }

        // Step 3: If we've used all n open and n close parentheses
        if (left == right && left == n) {
            // Add this valid combination to set
            set.add(sb.toString());
        }

        // Step 4: Try adding opening parenthesis
        helper(left + 1, right, n, sb.append("("), set);
        // Step 4a: Backtrack by removing the added opening parenthesis
        sb.deleteCharAt(sb.length() - 1);
        
        // Step 5: Try adding closing parenthesis
        helper(left, right + 1, n, sb.append(")"), set);
        // Step 5a: Backtrack by removing the added closing parenthesis
        sb.deleteCharAt(sb.length() - 1);
    }
}

