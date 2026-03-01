/**
 * Problem: Reverse a linked list using recursion.
 * Algorithm: Recursive approach - reach end of list, then reverse by modifying links.
 * Time Complexity: O(n) where n is the number of nodes
 * Space Complexity: O(n) for recursion stack depth
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    /**
     * Reverses a linked list using recursion.
     * Example: 1 -> 2 -> 3 becomes 3 -> 2 -> 1
     * 
     * @param A the head of the linked list
     * @return the new head of the reversed list
     */
    public ListNode reverseList(ListNode A) {
        // Step 1: Base case - if list is empty, return null
        if (A == null) {
            return A;
        }
        
        // Step 2: Store next node before we modify A
        ListNode rest = A.next;
        
        // Step 3: Base case - if current node is last node, return it
        // This becomes the new head of reversed list
        if (rest == null) {
            return A;
        }
        
        // Step 4: Disconnect current node from the rest
        // This prevents cycles when we reverse
        A.next = null;
        
        // Step 5: Recursively reverse the rest of the list
        // rest will be the head of already-reversed sublist
        ListNode reverse = reverseList(rest);
        
        // Step 6: Connect the rest of the list back to current node
        // After recursion, 'rest' points to what was a middle/end node
        // Now we make 'rest' point back to 'A' to reverse the link
        rest.next = A;
        
        // Step 7: Return the new head (unchanged in recursion)
        return reverse;
    }
}
