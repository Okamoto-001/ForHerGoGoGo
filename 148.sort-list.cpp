/*
 * @lc app=leetcode id=148 lang=cpp
 *
 * [148] Sort List
 *
 * https://leetcode.com/problems/sort-list/description/
 *
 * algorithms
 * Medium (38.55%)
 * Likes:    2059
 * Dislikes: 102
 * Total Accepted:    227K
 * Total Submissions: 582.2K
 * Testcase Example:  '[4,2,1,3]'
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * Example 1:
 * 
 * 
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
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
    ListNode* sortList(ListNode* head) {
        int n = 0;
        for (auto t = head; t; t = t->next) n++;

        auto dummy = new ListNode(-1);
        dummy->next = head;

        for (int i = 1; i < n; i *= 2) {
            auto cur = dummy;
            for (int j = 0; j + i < n; j += i*2) {
                auto left = cur->next, right = cur->next;

                for (int k = 0; k < i; k++) right = right->next;
                int l = 0, r = 0;

                while ( l < i && r < i && right) {
                    if (left->val <= right->val) {
                        cur->next =left;
                        cur = left;
                        left = left->next;
                        l++;
                    } else {
                        cur->next = right;
                        cur = right;
                        right = right->next;
                        r++;
                    }
                }

                while ( l < i) {
                    cur->next = left;
                    cur = left;
                    left = left->next;
                    l++;
                }

                while ( r < i && right) {
                    cur->next = right;
                    cur = right;
                    right = right->next;
                    r++;
                }

                cur->next = right;
            }
        }
        return dummy->next;
    }
};
// @lc code=end

