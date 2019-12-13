/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
 *
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (49.82%)
 * Likes:    2939
 * Dislikes: 424
 * Total Accepted:    755K
 * Total Submissions: 1.5M
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * Example:
 * 
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(0);
            ListNode ans = dummyHead;

            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    dummyHead.next = l1;
                    l1 = l1.next;
                    dummyHead = dummyHead.next;
                }else {
                    dummyHead.next = l2;
                    l2 = l2.next;
                    dummyHead = dummyHead.next;
                }
            }

            if (l1 == null)
                dummyHead.next = l2;
            else
                dummyHead.next = l1;

            return ans.next;

    }
}
// @lc code=end

