/**
 * Problem: Generate all subsets (power set) of an array.
 * Algorithm: Backtracking - make choice to include/exclude each element.
 * Time Complexity: O(2^n) - there are 2^n subsets
 * Space Complexity: O(n) for recursion depth
 */
public class Solution {
  /**
   * Generates all subsets of the given array.
   * 
   * @param A the input array
   * @return ArrayList of all subsets
   * 
   * Example:
   *   A = [1, 2, 3]
   *   Output: [[], [1], [2], [3], [1,2], [1,3], [2,3], [1,2,3]]
   */
  public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
    // Step 1: Create result list and sort array for consistent output
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    Collections.sort(A);
    
    // Step 2: Start backtracking from index 0 to generate all subsets
    helper(A, ans, new ArrayList<>(), 0);
    
    // Step 3: Return all subsets
    return ans;
  }

  /**
   * Backtracking helper to generate all subsets.
   * 
   * @param A the original array
   * @param ans the result list of all subsets
   * @param curr the current subset being built
   * @param idx the current index in array (start from this to avoid duplicates)
   */
  private void helper(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> curr, int idx) {
    // Step 1: Add current subset to result (even if empty)
    ans.add(new ArrayList<>(curr));
    
    // Step 2: Try adding each element from idx onwards to create new subsets
    for (int i = idx; i < A.size(); i++) {
      // Step 2a: Choose - add element to current subset
      curr.add(A.get(i));
      
      // Step 2b: Explore - recurse to add more elements (start from i+1)
      helper(A, ans, curr, i + 1);
      
      // Step 2c: Un-choose - backtrack by removing the element
      curr.remove(curr.size() - 1);
    }
  }
}

