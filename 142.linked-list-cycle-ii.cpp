/*
 * @lc app=leetcode id=142 lang=cpp
 *
 * [142] Linked List Cycle II
 *
 * https://leetcode.com/problems/linked-list-cycle-ii/description/
 *
 * algorithms
 * Medium (34.38%)
 * Likes:    1916
 * Dislikes: 154
 * Total Accepted:    258.6K
 * Total Submissions: 751.4K
 * Testcase Example:  '[3,2,0,-4]\n1'
 *
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null.
 * 
 * To represent a cycle in the given linked list, we use an integer pos which
 * represents the position (0-indexed) in the linked list where tail connects
 * to. If pos is -1, then there is no cycle in the linked list.
 * 
 * Note: Do not modify the linked list.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the
 * second node.
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the
 * first node.
 * 
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 * 
 * 
 * 
 * 
 * 
 * 
 * Follow-up:
 * Can you solve it without using extra space?
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

// 另外感谢@watay147提供的另一种思路，可以用公式来说明：a,b,c,x,ya,b,c,x,y 的含义同上，我们用 zz 表示从 cc 点顺时针走到 bb 的距离。则第一次相遇时 secondsecond 所走的距离是 x+(y+z)∗n+yx+(y+z)∗n+y, nn 表示圈数，同时 secondsecond 走过的距离是 firstfirst 的两倍，也就是 2(x+y)2(x+y)，所以我们有 x+(y+z)∗n+y=2(x+y)x+(y+z)∗n+y=2(x+y)，所以 x=(n−1)×(y+z)+zx=(n−1)×(y+z)+z。那么我们让 secondsecond 从 cc 点开始走，走 xx 步，会恰好走到 bb 点；让 firstfirst 从 aa 点开始走，走 xx 步，也会走到 bb 点。

// 作者：yxc
// 链接：https://www.acwing.com/solution/LeetCode/content/241/
// 来源：AcWing
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    ListNode *detectCycle(ListNode *head) {
        auto slow = head, fast = head;

        while (fast) {
            slow = slow->next;
            fast = fast->next;
            if (fast) fast = fast->next;
            else break;

            if (slow == fast) {
                slow = head;
                while (fast != slow) {
                    slow = slow->next;
                    fast = fast->next;
                }
                return fast;
            }
        }
        return NULL;
    }
};
// @lc code=end

