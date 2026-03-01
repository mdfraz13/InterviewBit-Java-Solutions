/**
 * Problem: Given phone keypad digits, find all possible letter combinations.
 * Phone keypad: 2=abc, 3=def, 4=ghi, 5=jkl, 6=mno, 7=pqrs, 8=tuv, 9=wxyz
 * Algorithm: Backtracking - map each digit to letters and explore all combinations.
 * Time Complexity: O(4^n) where n is number of digits (max 4 letters per digit)
 * Space Complexity: O(n) for recursion depth
 */
public class Solution {
    /**
     * Generates all possible letter combinations from phone digits.
     * 
     * @param A the digit string
     * @return ArrayList of all possible letter combinations
     * 
     * Example:
     *   A = "23"
     *   Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
     */
    public static ArrayList<String> letterCombinations(String A) {
        // Step 1: Create mapping from digits to letter combinations
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "0");
        map.put(1, "1");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        // Step 2: Create result list
        ArrayList<String> ans = new ArrayList<>();

        // Step 3: Start backtracking from digit index 0
        letterCombinationsHelper(A, ans, map, new StringBuilder(), 0);

        // Step 4: Return all combinations
        return ans;
    }

    /**
     * Backtracking helper to generate all letter combinations.
     * 
     * @param a the digit string
     * @param ans the result list
     * @param map the digit to letters mapping
     * @param sb the current combination being built
     * @param id the current digit index
     */
    private static void letterCombinationsHelper(String a, ArrayList<String> ans, Map<Integer, String> map, StringBuilder sb, int id) {
        // Step 1: If index exceeds string length, stop
        if (id > a.length()) {
            return;
        }

        // Step 2: If we've processed all digits and built a combination of same length
        if (id == a.length() && sb.length() == a.length()) {
            // Add the complete combination
            ans.add(new StringBuilder(sb.toString()).toString());
        }
        // Step 3: Try all letters for each digit
        else {
            // Step 3a: For each digit starting from current index
            for (int i = id; i < a.length(); i++) {
                // Step 3b: Get the letters mapped to current digit
                String mapping = map.get(Integer.valueOf(String.valueOf(a.charAt(i))));
                
                // Step 3c: For each letter in the mapped string
                for (int j = 0; j < mapping.length(); j++) {
                    // Step 3d: Choose - append current letter to combination
                    sb.append(mapping.charAt(j));

                    // Step 3e: Explore - recurse to next digit
                    letterCombinationsHelper(a, ans, map, sb, i + 1);

                    // Step 3f: Un-choose - backtrack by removing the letter
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }
}

