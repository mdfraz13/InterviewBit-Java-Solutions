/**
 * Problem: Find two lines from an array that can hold the maximum water.
 * Water container area = min(height[i], height[j]) * (j - i)
 * Algorithm: Two-pointer approach - start from ends and move inward.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class Solution {
  /**
   * Finds the maximum area of water that can be contained between two lines.
   * 
   * @param A ArrayList of integers representing heights of lines
   * @return the maximum area that can be contained
   * 
   * Example:
   *   A = [1, 8, 6, 2, 5, 4, 8, 3, 7]
   *   Output: 49 (between heights 8 and 7, distance 8, area = min(8,7) * 8 = 56... recalculate)
   *   Correct: max area is min(8,7) * 7 = 49 or min(6,8) * 8 = 48
   */
  public int maxArea(ArrayList<Integer> A) {
    // Step 1: Initialize variable to track maximum area found so far
    int maximumArea = 0;
    
    // Step 2: Initialize two pointers - one at start, one at end
    int start = 0;
    int end = A.size() - 1;
    
    // Step 3: Move pointers inward comparing areas
    while (start < end) {
      // Step 3a: Calculate height as the minimum of two lines
      // (water level is limited by shorter line)
      int minHeight = Math.min(A.get(start), A.get(end));
      
      // Step 3b: Calculate area: height * width (distance between pointers)
      int currArea = minHeight * (end - start);
      
      // Step 3c: Update maximum area if current area is larger
      maximumArea = Math.max(maximumArea, currArea);
      
      // Step 3d: Move the pointer pointing to shorter line
      // Logic: moving the shorter line might give us a better area
      // (we're increasing distance slightly, but have potential for taller line)
      if (A.get(start) <= A.get(end)) {
        start++;
      }
      else {
        end--;
      }
    }
    
    // Step 4: Return the maximum area found
    return maximumArea;
  }
}
