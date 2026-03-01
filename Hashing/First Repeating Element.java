/**
 * Problem: Find the first element that is repeated in the array.
 * Return the element value, or -1 if no element repeats.
 * Algorithm: Use two HashMaps - one for frequency, one for first occurrence index.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class Solution {
  /**
   * Finds the first element that appears more than once in an array.
   * 
   * @param A the input ArrayList of integers
   * @return the value of the first repeating element, or -1 if no element repeats
   * 
   * Example:
   *   A = [10, 5, 10, 3, 5]
   *   Output: 10 (first element that repeats, appeared at indices 0 and 2)
   *   
   *   A = [1, 2, 3, 4]
   *   Output: -1 (no repeating elements)
   */
  public int solve(ArrayList<Integer> A) {
    // Step 1: Create HashMap to count frequency of each element
    Map<Integer, Integer> freqCounter = new HashMap<>();
    
    // Step 2: Create HashMap to store first occurrence index of each element
    Map<Integer, Integer> indexCounter = new HashMap<>();
    
    // Step 3: Iterate through array to populate both maps
    for (int i = 0; i < A.size(); i++) {
      // Step 3a: Increment frequency count for current element
      freqCounter.put(A.get(i), freqCounter.getOrDefault(A.get(i), 0) + 1);
      
      // Step 3b: Store first occurrence index (putIfAbsent ensures we keep first occurrence)
      indexCounter.putIfAbsent(A.get(i), i);
    }
    
    // Step 4: Find the element with frequency > 1 that has minimum first index
    int minRepeatingIndex = Integer.MAX_VALUE;
    
    // Step 4a: Iterate through all unique elements
    for (Integer key : freqCounter.keySet()) {
      // Step 4b: Check if this element appears more than once
      if (freqCounter.get(key) > 1) {
        // Step 4c: Update minimum index if this repeating element appeared earlier
        minRepeatingIndex = Math.min(minRepeatingIndex, indexCounter.get(key));
      }
    }
    
    // Step 5: Return the element at minimum first occurrence, or -1 if none found
    return minRepeatingIndex == Integer.MAX_VALUE ? -1 : A.get(minRepeatingIndex);
  }
}
