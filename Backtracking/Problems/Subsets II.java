/**
 * Problem: Generate all subsets from array with duplicates (no duplicate subsets).
 * Algorithm: Backtracking with duplicate skipping at the same recursion level.
 * Time Complexity: O(2^n)
 * Space Complexity: O(n) for recursion depth
 */
public class Solution {
  /**
   * Generates all unique subsets of array with duplicates.
   * 
   * @param A the input array (may contain duplicates)
   * @return ArrayList of all unique subsets
   * 
   * Example:
   *   A = [1, 2, 2]
   *   Output: [[], [1], [2], [1,2], [2,2], [1,2,2]]
   */
  public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
    // Step 1: Sort array to group duplicates for easy skipping
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    Collections.sort(A);
    
    // Step 2: Start backtracking from index 0
    helper(A, new ArrayList<>(), ans, 0);
    
    // Step 3: Return all unique subsets
    return ans;
  }

  /**
   * Backtracking helper to generate all unique subsets.
   * 
   * @param a the sorted array with duplicates
   * @param curr the current subset being built
   * @param ans the result list of all subsets
   * @param idx the current starting index
   */
  private void helper(ArrayList<Integer> a, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> ans, int idx) {
    // Step 1: Add current subset to result (including empty set)
    ans.add(new ArrayList<>(curr));
    
    // Step 2: If reached end of array, return
    if (idx >= a.size()) {
      return;
    }
    
    // Step 3: Try adding each element from idx onwards to create new subsets
    for (int i = idx; i < a.size(); i++) {
      // Step 3a: Skip duplicate values at the same recursion level
      // If current value equals previous and we're not using first occurrence, skip it
      if (i > idx && a.get(i).equals(a.get(i - 1))) {
        continue;
      }
      
      // Step 3b: Choose - add element to current subset
      curr.add(a.get(i));
      
      // Step 3c: Explore - recurse from next index (i+1 to avoid using same element twice)
      helper(a, curr, ans, i + 1);
      
      // Step 3d: Un-choose - backtrack by removing element
      curr.remove(curr.size() - 1);
    }
  }
}

