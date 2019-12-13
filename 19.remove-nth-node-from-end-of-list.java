/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
 *
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 *
 * algorithms
 * Medium (34.64%)
 * Likes:    2364
 * Dislikes: 177
 * Total Accepted:    489.5K
 * Total Submissions: 1.4M
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given a linked list, remove the n-th node from the end of list and return
 * its head.
 * 
 * Example:
 * 
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5.
 * 
 * 
 * Note:
 * 
 * Given n will always be valid.
 * 
 * Follow up:
 * 
 * Could you do this in one pass?
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // # 3 save into list

        List<ListNode> list = new ArrayList<>();
        int len = 0;
        ListNode cur = head;

        while (cur != null) {
            len++;
            list.add(cur);
            cur = cur.next;
        }

        //delete head
        if (len == 1) return null;
        if (len-n == 0) return head.next;

        ListNode pre = list.get(len-n-1);
        pre.next = pre.next.next;

        return head;

        // // # 2 one pass; O(n)

        // ListNode dummyHead = new ListNode(0);
        // dummyHead.next = head;

        // ListNode first = dummyHead, second = dummyHead;

        // //first goes to n
        // for (int i = 0; i < n+1; i++)
        //     first = first.next;

        // while (first != null) {
        //     first = first.next;
        //     second = second.next;
        // }

        // second.next = second.next.next;
        // return dummyHead.next;


        // # 1 O(n+n)-> O(n)
        // //find the length
        // int  len = 0;
        // ListNode cur = head;
        // while (cur != null) {
        //     cur = cur.next;
        //     len += 1;
        // }

        // //delete the head
        // if (len == 1) return null;
        // if (len-n == 0) return head.next;

        // //the prevNode before needToDelete, so need to minus 1
        // ListNode pre = head;
        // for (int i = 0; i < len-n-1; i++) {
        //     pre = pre.next;
        // }
        // pre.next = pre.next.next;
        // return head;
    }
}
// @lc code=end

