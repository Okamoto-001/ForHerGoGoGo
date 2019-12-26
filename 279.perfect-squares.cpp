/*
 * @lc app=leetcode id=279 lang=cpp
 *
 * [279] Perfect Squares
 *
 * https://leetcode.com/problems/perfect-squares/description/
 *
 * algorithms
 * Medium (43.74%)
 * Likes:    1949
 * Dislikes: 161
 * Total Accepted:    228.5K
 * Total Submissions: 522.2K
 * Testcase Example:  '12'
 *
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * Example 1:
 * 
 * 
 * Input: n = 12
 * Output: 3 
 * Explanation: 12 = 4 + 4 + 4.
 * 
 * Example 2:
 * 
 * 
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */

// @lc code=start
class Solution {
public:
    int numSquares(int n) {
        vector<int> dp(n+1, __INT_MAX__);
        dp[0] = 0;

        for (int i = 0; i <= n; i++) {
            for (int j = 1; i + j*j <= n; j++) {
                dp[i + j*j] = min(dp[i+j*j], dp[i]+1);
            }
        }

        return dp.back();

    }
};
// @lc code=end

