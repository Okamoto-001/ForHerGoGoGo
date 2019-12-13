/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
 *
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 *
 * algorithms
 * Medium (47.38%)
 * Likes:    1590
 * Dislikes: 137
 * Total Accepted:    384K
 * Total Submissions: 810.3K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        
        // # 1 : O(1) O(1)
        // ListNode dummyHead = new ListNode(0);
        // dummyHead.next = head;
        // ListNode ptr = dummyHead;

        // while (ptr.next != null && ptr.next.next != null) {
        //     ListNode swap1 = ptr.next;
        //     ListNode swap2 = ptr.next.next;
        //     ptr.next = swap2; // connect to dummyHead
        //     swap1.next = swap2.next;
        //     swap2.next = swap1;
        //     ptr = swap1;
        // }

        // return dummyHead.next;


        // # recursion : O(n)

        //base case
        if (head == null || head.next == null)
            return head;
        
        ListNode swapped = head.next;
        //connect it to head.next.next;
        head.next = swapPairs(head.next.next);

        swapped.next = head;
        return swapped;
    }
}
// @lc code=end

