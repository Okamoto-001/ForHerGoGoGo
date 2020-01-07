/*
 * @lc app=leetcode id=91 lang=cpp
 *
 * [91] Decode Ways
 *
 * https://leetcode.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (23.34%)
 * Likes:    1936
 * Dislikes: 2178
 * Total Accepted:    324.3K
 * Total Submissions: 1.4M
 * Testcase Example:  '"12"'
 *
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * Given a non-empty string containing only digits, determine the total number
 * of ways to decode it.
 * 
 * Example 1:
 * 
 * 
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2
 * 6).
 * 
 */

// @lc code=start
class Solution {
public:
    int numDecodings(string s) {
        if (s.empty() || s[0] == '0') return 0;

        vector<int> dp(s.size()+1, 0);

        dp[0] = 1;

        for (int i = 1; i < dp.size(); i++) {
            //20 only one form

            //one digits
            dp[i] = (s[i-1] == '0') ? 0 : dp[i-1];

            //two digits
            if (i > 1 && (s[i-2] == '1' || (s[i-2] == '2' && s[i-1] <= '6'))) {
                dp[i] += dp[i-2];
            }
        }
        return dp.back();
    }
};
// @lc code=end

