/**
 * Problem: Generate all combinations of k numbers from 1 to n.
 * Algorithm: Backtracking - recursively build combinations of exact size k.
 * Time Complexity: O(C(n,k)) - number of combinations
 * Space Complexity: O(k) recursion depth
 */
public class Solution {
  /**
   * Generates all combinations of k numbers from 1 to n.
   * 
   * @param A n (range: 1 to n)
   * @param B k (size of each combination)
   * @return ArrayList of all combinations of size k
   * 
   * Example:
   *   A = 4, B = 2
   *   Output: [[1,2], [1,3], [1,4], [2,3], [2,4], [3,4]]
   */
  public ArrayList<ArrayList<Integer>> combine(int A, int B) {
    // Step 1: Create result list
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    
    // Step 2: Start backtracking from number 1
    helper(ans, A, 1, B, new ArrayList<>());
    
    // Step 3: Return all combinations
    return ans;
  }

  /**
   * Backtracking helper to build combinations.
   * 
   * @param ans the result list
   * @param a the upper limit n
   * @param idx the current number to consider (1 to n)
   * @param b the size k of combinations needed
   * @param curr the current combination being built
   */
  private void helper(ArrayList<ArrayList<Integer>> ans, int a, int idx, int b, ArrayList<Integer> curr) {
    // Step 1: If current combination has enough elements, add it
    if (curr.size() >= b) {
      // Only add if size equals exactly b (avoids duplicates)
      if (curr.size() == b) {
        ans.add(new ArrayList<>(curr));
      }
      return;
    }
    
    // Step 2: Try each number from idx to n
    // Only go up to n-remaining_needed to ensure we can complete the combination
    for (int i = idx; i <= a; i++) {
      // Step 2a: Choose - add current number
      curr.add(i);
      
      // Step 2b: Explore - recurse from next number (i+1 to avoid duplicates)
      helper(ans, a, i + 1, b, curr);
      
      // Step 2c: Un-choose - backtrack
      curr.remove(curr.size() - 1);
    }
  }
}

