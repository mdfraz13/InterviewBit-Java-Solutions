/**
 * Problem: Find all combinations of numbers from array that sum to target.
 * Numbers can be reused, and duplicates in result should be avoided.
 * Algorithm: Backtracking - explore all possible combinations and track valid ones.
 * Time Complexity: O(2^n) in worst case for exploring all combinations
 * Space Complexity: O(n) for recursion depth + output space
 */
public class Solution {
  /**
   * Finds all unique combinations that sum to target B.
   * 
   * @param A the list of candidate numbers (may contain duplicates)
   * @param B the target sum
   * @return ArrayList of all unique combinations that sum to B
   * 
   * Example:
   *   A = [3, 6, 2], B = 9
   *   Output: [[3, 3, 3], [3, 6], [2, 2, 2, ...]]  or similar
   */
  public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
    // Step 1: Sort array for consistency and easier duplicate handling
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    Collections.sort(A);
    
    // Step 2: Start backtracking from index 0
    // Current combination, remaining sum, and starting index
    helper(A, ans, new ArrayList<>(), B, 0);
    
    // Step 3: Return all valid combinations found
    return new ArrayList<>(ans);
  }

  /**
   * Backtracking helper to explore all combinations.
   * 
   * @param a the candidate numbers array
   * @param ans the result list of all valid combinations
   * @param curr the current combination being built
   * @param b the remaining sum needed
   * @param idx the starting index to avoid duplicates
   */
  private void helper(ArrayList<Integer> a, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> curr, int b, int idx) {
    // Step 1: If remaining sum becomes negative, stop this path
    if (b < 0) {
      return;
    }
    
    // Step 2: If remaining sum becomes 0, we found a valid combination
    if (b == 0) {
      // Add only if this combination is not already in the result
      if (!ans.contains(curr)) {
        ans.add(new ArrayList<>(curr));
      }
      return;
    }
    
    // Step 3: Try adding each number starting from idx (allows reuse)
    for (int i = idx; i < a.size(); i++) {
      // Step 3a: Choose - add current number to combination
      curr.add(a.get(i));
      
      // Step 3b: Explore - recurse with same index (allows reuse) and reduced sum
      helper(a, ans, curr, b - a.get(i), i);
      
      // Step 3c: Un-choose - backtrack by removing the added number
      curr.remove(curr.size() - 1);
    }
  }
}
