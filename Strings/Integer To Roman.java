/**
 * Problem: Convert an integer to its Roman numeral representation.
 * Algorithm: Use arrays for each place value (thousands, hundreds, tens, ones).
 * Each array contains Roman numerals for values 0-9 in that position.
 * Time Complexity: O(1) since we process at most 4 digits
 * Space Complexity: O(1)
 */
public class Solution {
    /**
     * Converts an integer to a Roman numeral string.
     * 
     * @param num the integer to convert (1 to 3999)
     * @return the Roman numeral representation
     * 
     * Example:
     *   3 -> "III"
     *   58 -> "LVIII"
     *   1994 -> "MCMXCIV"
     */
    public String intToRoman(int num) {
        // Step 1: Define arrays for each place value (ones, tens, hundreds, thousands)
        // Each index represents the digit in that position
        // Index 1 = digit 1, index 2 = digit 2, etc.
        
        // Thousands place: 0, M, MM, MMM (for 0-3 thousands)
        String[] m = {"", "M", "MM", "MMM"};
        
        // Hundreds place: special notation for 400, 500, 900
        // 0, C, CC, CCC, CD, D, DC, DCC, DCCC, CM (for 0-9 hundreds)
        String[] c = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        
        // Tens place: special notation for 40, 50, 90
        // 0, X, XX, XXX, XL, L, LX, LXX, LXXX, XC (for 0-9 tens)
        String[] x = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        
        // Ones place: special notation for 4, 5, 9
        // 0, I, II, III, IV, V, VI, VII, VIII, IX (for 0-9 ones)
        String[] i = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        // Step 2: Extract each digit and map to Roman numerals
        
        // Thousands digit (divide by 1000, take quotient)
        String thousands = m[num / 1000];
        
        // Hundreds digit (divide by 1000, take remainder, then divide by 100)
        String hundreds = c[num % 1000 / 100];
        
        // Tens digit (divide by 100, take remainder, then divide by 10)
        String tens = x[num % 100 / 10];
        
        // Ones digit (divide by 10, take remainder)
        String ones = i[num % 10];

        // Step 3: Concatenate all parts to form complete Roman numeral
        String ans = thousands + hundreds + tens + ones;

        // Step 4: Return the Roman numeral string
        return ans;
    }
}
