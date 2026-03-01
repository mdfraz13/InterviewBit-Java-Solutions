public class Solution {
  /**
   * Adds one to a number represented as an ArrayList of integers.
   * 
   * This method takes an ArrayList of integers representing the digits of a number
   * and increments the number by one. It handles the carry-over logic when digits
   * exceed 9, and manages the case where a new digit needs to be added (e.g., 999 + 1 = 1000).
   * Leading zeros are removed from the result before returning.
   * 
   * @param A an ArrayList of integers representing digits of a number (each element should be 0-9)
   * @return an ArrayList of integers representing the digits of the incremented number,
   *         with leading zeros removed
   * 
   * Example:
   *   Input: [1, 2, 3] (represents 123)
   *   Output: [1, 2, 4] (represents 124)
   *   
   *   Input: [9, 9, 9] (represents 999)
   *   Output: [1, 0, 0, 0] (represents 1000)
   */
  public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
    // Step 1: Initialize carry to 1 (we're adding 1) and start from the last digit
    int carry = 1;
    int idx = A.size() - 1;
    
    // Step 2: Process digits from right to left, handling the carry
    while (idx >= 0) {
      // Step 2a: Add current digit and carry
      int temp = A.get(idx) + carry;
      
      // Step 2b: Determine if there's a carry for the next digit (if sum > 9)
      carry = temp > 9 ? 1 : 0;
      
      // Step 2c: Keep only the last digit (0-9)
      temp = temp > 9 ? temp % 10 : temp;
      
      // Step 2d: Update the current digit with the new value
      A.set(idx, temp);
      
      // Step 2e: Stop if no carry, optimization to avoid unnecessary iterations
      if (carry == 0) {
        break;
      }
      
      // Step 2f: Move to the previous digit
      idx--;
    }
    
    // Step 3: If there's still a carry after processing all digits, 
    // it means we need an extra digit at the front (e.g., 999 + 1 = 1000)
    if (carry > 0) {
      A.add(0, carry);
    }
    
    // Step 4: Remove leading zeros from the result
    ArrayList<Integer> list = new ArrayList<>();
    idx = 0;
    
    // Step 4a: Skip all leading zeros
    while (idx < A.size() && A.get(idx) == 0) {
      idx++;
    }
    
    // Step 4b: Add all remaining digits to the result list
    while (idx < A.size()) {
      list.add(A.get(idx++));
    }
    
    // Step 5: Return the final result
    return list;
  }
}

