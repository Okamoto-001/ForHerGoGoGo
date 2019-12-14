import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
 *
 * algorithms
 * Medium (34.75%)
 * Likes:    1154
 * Dislikes: 94
 * Total Accepted:    212.7K
 * Total Submissions: 612.1K
 * Testcase Example:  '[1,2,3,3,4,4,5]'
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * Example 1:
 * 
 * 
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 1->1->1->2->3
 * Output: 2->3
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
    public ListNode deleteDuplicates(ListNode head) {

        // # 2 recursion: O(n)
        if (head == null) return null;
        
        if (head.next != null && head.next.val == head.val) {
            //move
            while (head.next != null &&  head.next.val == head.val) {
                head = head.next;
            }

            return deleteDuplicates(head.next);
        }
        else {
            head.next = deleteDuplicates(head.next);
        }
        return head;

        // # 1: O(n)
        // ListNode dummyHead = new ListNode(0);
        // dummyHead.next = head;
        // ListNode pre = dummyHead, cur = head;
        
        // boolean equal = false;

        // while (cur != null && cur.next != null) {

        //     //equal
        //     while (cur.next != null && cur.val == cur.next.val) {
        //         //move 
        //         cur = cur.next;
        //         equal = true;
        //     }

        //     //connect pre
        //     if (equal) {
        //         pre.next = cur.next;
        //         equal = false;
        //     }
        //     else {
        //         pre = cur;
        //     }
        //     cur = cur.next;
        // }
        // return dummyHead.next;
    }
}
// @lc code=end

//test
// [] -> null
// d->1->2->3->3->4  => 
// p->c
//    p->c
//       p->c
//          p->   c