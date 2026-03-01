/**
 * Problem: Generate all permutations (arrangements) of an array.
 * Algorithm: Backtracking - track used elements with HashSet to build all orderings.
 * Time Complexity: O(n! * n) where n! permutations and n to copy each
 * Space Complexity: O(n) for recursion and HashSet
 */
public class Solution {
  /**
   * Generates all permutations of the given array.
   * 
   * @param A the input array
   * @return ArrayList of all permutations
   * 
   * Example:
   *   A = [1, 2, 3]
   *   Output: [[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]]
   */
  public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
    // Step 1: Create result list
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    
    // Step 2: Start backtracking with empty current permutation and empty used set
    helper(A, ans, new ArrayList<Integer>(), new HashSet<>());
    
    // Step 3: Return all permutations
    return ans;
  }

  /**
   * Backtracking helper to generate all permutations.
   * 
   * @param A the original array
   * @param ans the result list
   * @param curr the current permutation being built
   * @param set the set of elements already used in current permutation
   */
  private void helper(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> curr, Set<Integer> set) {
    // Step 1: If current permutation has all elements, add it to result
    if (curr.size() == A.size()) {
      ans.add(new ArrayList<>(curr));
    }
    else {
      // Step 2: Try adding each element that hasn't been used yet
      for (int i = 0; i < A.size(); i++) {
        // Step 2a: Check if element is not already used in current permutation
        if (!set.contains(A.get(i))) {
          // Step 2b: Choose - add element to current permutation
          set.add(A.get(i));
          curr.add(A.get(i));
          
          // Step 2c: Explore - recurse to add more elements
          helper(A, ans, curr, set);
          
          // Step 2d: Un-choose - backtrack
          curr.remove(curr.size() - 1);
          set.remove(A.get(i));
        }
      }
    }
  }
}

