/*
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
 *
 * https://leetcode.com/problems/partition-list/description/
 *
 * algorithms
 * Medium (39.13%)
 * Likes:    904
 * Dislikes: 241
 * Total Accepted:    187.3K
 * Total Submissions: 478.5K
 * Testcase Example:  '[1,4,3,2,5,2]\n3'
 *
 * Given a linked list and a value x, partition it such that all nodes less
 * than x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * Example:
 * 
 * 
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
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
    public ListNode partition(ListNode head, int x) {
        // # 2 : min and max

        ListNode minHead = new ListNode(0);
        ListNode min = minHead;

        ListNode maxHead = new ListNode(0);
        ListNode max = maxHead;

        while (head != null) {
            //move min
            if (head.val < x) {
                min.next = head;
                min = min.next;
            }
            else {
                max.next = head;
                max = max.next;
            }

            head = head.next;
        }

        //connect min and max
        max.next = null;
        min.next = maxHead.next;

        return minHead.next;

        // # 1 : O(n)
        // ListNode dummyHead = new ListNode(0);
        // dummyHead.next = head;
        // ListNode tail = head;

        
        // //find the first node >= x, also need to check head
        // head = dummyHead;
        // while (head.next != null) {
        //     if (head.next.val >= x) {
        //         tail = head;
        //         head = head.next;
        //         break;
        //     }
        //     else {
        //         head = head.next;
        //     }
        // }

        // //move smaller node
        // while (head.next != null) {
        //     if (head.next.val < x) {
        //         ListNode move = head.next;
        //         head.next = move.next;
        //         move.next = tail.next;
        //         tail.next = move;

        //         //update tail
        //         tail = move;
        //     }
        //     else {
        //         head = head.next;
        //     }
        // }
        // return dummyHead.next; 
    }
}
// @lc code=end

