/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 *
 * https://leetcode.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (32.34%)
 * Likes:    6533
 * Dislikes: 1703
 * Total Accepted:    1.1M
 * Total Submissions: 3.5M
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example:
 * 
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        // # 1 : straight way, need to carry; O(max (p1.len, p2.len))
        // ListNode dummyHead = new ListNode(0); // so we don't need to change head's value

        // ListNode p1 = l1, p2 = l2, cur = dummyHead;
        // int carry = 0; // for 9 + 9 + 1 =19-> next need to plus one

        // while (p1 != null || p2 != null) {
        //     int p1Val = (p1 != null) ? (p1.val) : 0;
        //     int p2Val = (p2 != null) ? (p2.val) : 0;
            
        //     //may need to plus one
        //     int sum = carry + p1Val + p2Val;
            
        //     carry = sum/10; // 19 /10  = 1
        //     cur.next = new ListNode(sum%10); // 19 % 10 = 1...9-> 9
        //     cur = cur.next;
            
        //     if (p1 != null) p1 = p1.next;
        //     if (p2 != null) p2 = p2.next;
        // }

        // //for the last case, may need to plus one
        // if (carry > 0)
        //     cur.next = new ListNode(carry);

        // return dummyHead.next;
    }
}


// reverse linkedList

// public reverseLinkedList(ListNode head) {
//     if (head = null) return null;

//     ListNode cur = head, nextNode, newHead = null;

//     while (cur != null) {
//         nextNdoe = cur.next;
//         cur.next = newHead;
//         newHead = cur;
//         cur = newNode;
//     }

// }

// @lc code=end

