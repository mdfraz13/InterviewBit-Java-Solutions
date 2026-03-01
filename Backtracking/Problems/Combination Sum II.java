/**
 * Problem: Find all unique combinations with target sum from array with duplicates.
 * Each number can be used at most once, and result should have no duplicates.
 * Algorithm: Backtracking with duplicate skipping and index increment to avoid reuse.
 * Time Complexity: O(2^n) in worst case
 * Space Complexity: O(n) for recursion depth
 */
public class Solution {
  /**
   * Finds all unique combinations that sum to target B.
   * Each element can be used at most once.
   * 
   * @param a the list of candidate numbers (may contain duplicates)
   * @param b the target sum
   * @return ArrayList of all unique combinations that sum to B
   * 
   * Example:
   *   a = [10, 1, 2, 7, 6, 1, 5], b = 8
   *   Output: [[1,1,6], [1,2,5], [1,7], [2,6]]  (one 1 used only once per combo)
   */
  public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
    // Step 1: Sort array to group duplicates and enable easy duplicate skipping
    Collections.sort(a);
    
    // Step 2: Create result list
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    
    // Step 3: Start backtracking from index 0
    helper(a, ans, new ArrayList<>(), b, 0);
    
    // Step 4: Return all valid combinations
    return new ArrayList<>(ans);
  }

  /**
   * Backtracking helper to find all combinations.
   * 
   * @param a the sorted candidate array
   * @param ans the result list
   * @param curr the current combination being built
   * @param b the remaining sum needed
   * @param idx the starting index (each element used at most once)
   */
  private void helper(ArrayList<Integer> a, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> curr, int b, int idx) {
    // Step 1: If remaining sum becomes 0, we found valid combination
    if (b == 0) {
      ans.add(new ArrayList<>(curr));
    }
    // Step 2: If remaining sum is negative or no more elements, stop
    else if (b < 0 || idx == a.size()) {
      return;
    }
    // Step 3: Try including each element (skip duplicates)
    else {
      for (int i = idx; i < a.size(); i++) {
        // Step 3a: Skip duplicate values at same level
        // If current value equals previous and we didn't start with previous, skip
        if (i > idx && a.get(i).equals(a.get(i - 1))) {
          continue;
        }
        
        // Step 3b: Choose - add current element to combination
        curr.add(a.get(i));
        
        // Step 3c: Explore - recurse from next index (i+1 ensures each element used once)
        helper(a, ans, curr, b - a.get(i), i + 1);
        
        // Step 3d: Un-choose - backtrack
        curr.remove(curr.size() - 1);
      }
    }
  }
}

