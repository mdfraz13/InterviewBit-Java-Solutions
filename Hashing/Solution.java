/**
 * Problem: Find two numbers in an array that sum to a target value B.
 * Return the 1-based indices of the two numbers.
 * Algorithm: HashMap/Hash Table - Store indices as we iterate and check for complement.
 * Time Complexity: O(n)
 * Space Complexity: O(n) for the HashMap
 */
public class Solution {
  // DO NOT MODIFY THE LIST. IT IS READ ONLY
  /**
   * Finds two numbers in array A that sum to B.
   * 
   * @param A the input list of integers (read-only)
   * @param B the target sum
   * @return ArrayList with 1-based indices [i, j] where A[i-1] + A[j-1] = B, or empty if not found
   * 
   * Example:
   *   A = [1, 3, 5, 7], B = 8
   *   Output: [2, 4] because A[1] + A[3] = 3 + 5 = 8 (1-based indices)
   */
  public ArrayList<Integer> twoSum(final List<Integer> A, int B) {
    // Step 1: Create a HashMap to store number -> 1-based index mappings
    Map<Integer, Integer> map = new HashMap<>();
    
    // Step 2: Create result ArrayList to store the two indices
    ArrayList<Integer> list = new ArrayList<>();
    
    // Step 3: Iterate through each element in the array
    for (int i = 0; i < A.size(); i++) {
      // Step 3a: Calculate the complement needed to reach target B
      // If we need sum B and current number is A[i], we need (B - A[i])
      int complement = B - A.get(i);
      
      // Step 3b: Check if complement already exists in the map
      if (map.containsKey(complement)) {
        // Step 3c: Found the pair! Add indices and return
        // (map stores 1-based indices, so no need to add 1)
        list.add(map.get(complement));
        list.add(i + 1);  // Current index is i, but we need 1-based (i+1)
        break;
      }
      
      // Step 3d: If complement not found, store current number and its 1-based index
      // putIfAbsent ensures we keep the first occurrence (important for some variants)
      map.putIfAbsent(A.get(i), i + 1);
    }
    
    // Step 4: Return result (empty if no pair found, otherwise [idx1, idx2])
    return list;
  }
}

