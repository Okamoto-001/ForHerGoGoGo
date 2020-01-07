/*
 * @lc app=leetcode id=63 lang=cpp
 *
 * [63] Unique Paths II
 *
 * https://leetcode.com/problems/unique-paths-ii/description/
 *
 * algorithms
 * Medium (33.81%)
 * Likes:    1200
 * Dislikes: 195
 * Total Accepted:    247.1K
 * Total Submissions: 730.6K
 * Testcase Example:  '[[0,0,0],[0,1,0],[0,0,0]]'
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths
 * would there be?
 * 
 * 
 * 
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * Note: m and n will be at most 100.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * Output: 2
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 * 
 * 
 */

// @lc code=start
class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& g) {
        int row = g.size(), col = g[0].size();

        vector<vector<long long >> dp(row+1, vector<long long >(col+1));

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (g[i][j] == 1) continue;

                if (!i && !j) dp[i][j] = 1;

                if (i > 0) dp[i][j] += dp[i-1][j];

                if (j > 0) dp[i][j] += dp[i][j-1];
             }
        }
        return dp[row-1][col-1];
    }
};
// @lc code=end

