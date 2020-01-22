/*
 * @lc app=leetcode id=92 lang=cpp
 *
 * [92] Reverse Linked List II
 *
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 *
 * algorithms
 * Medium (36.68%)
 * Likes:    1648
 * Dislikes: 112
 * Total Accepted:    229.2K
 * Total Submissions: 624.7K
 * Testcase Example:  '[1,2,3,4,5]\n2\n4'
 *
 * Reverse a linked list from position m to n. Do it in one-pass.
 * 
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * 
 * Example:
 * 
 * 
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* reverseBetween(ListNode* head, int m, int n) {
        auto dummy = new ListNode(-1);
        dummy->next = head;
        auto a = dummy, b = dummy;

        for (int i = 0; i < m-1; i++) a = a->next;
        for (int i = 0; i < n; i++) b = b->next;
        auto c = a->next, d = b->next;
        for (auto p = a->next, q = p->next; q != d;) {
            auto o = q->next;
            q->next = p;
            p = q, q = o;
        }
        a->next = b;
        c->next = d;
        return dummy->next;
    }
};
// @lc code=end

