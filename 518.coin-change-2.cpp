/*
 * @lc app=leetcode id=518 lang=cpp
 *
 * [518] Coin Change 2
 *
 * https://leetcode.com/problems/coin-change-2/description/
 *
 * algorithms
 * Medium (45.47%)
 * Likes:    1134
 * Dislikes: 46
 * Total Accepted:    68.6K
 * Total Submissions: 150.5K
 * Testcase Example:  '5\n[1,2,5]'
 *
 * You are given coins of different denominations and a total amount of money.
 * Write a function to compute the number of combinations that make up that
 * amount. You may assume that you have infinite number of each kind of
 * coin.
 * 
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: amount = 5, coins = [1, 2, 5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: amount = 10, coins = [10] 
 * Output: 1
 * 
 * 
 * 
 * 
 * Note:
 * 
 * You can assume that
 * 
 * 
 * 0 <= amount <= 5000
 * 1 <= coin <= 5000
 * the number of coins is less than 500
 * the answer is guaranteed to fit into signed 32-bit integer
 * 
 * 
 */

// @lc code=start
class Solution {
public:
    int change(int amount, vector<int>& coins) {
        vector<vector<int>> dp(coins.size()+1, vector<int>(amount+1, 0));

        dp[0][0] = 1;

        for (int i = 1; i <= coins.size(); i++) { 
            //need dp[i][0] bc j >= coins[i-1] ? dp[i][j-coins[i-1]]
            //we can use 1 to make up amount
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {

                //j >= coins[i-1] so we need to plus cur coin
                dp[i][j] = dp[i-1][j] + (j >= coins[i-1] ? dp[i][j-coins[i-1]] : 0);
            }
        }

        return dp[coins.size()][amount];
        
    }
};
// @lc code=end

