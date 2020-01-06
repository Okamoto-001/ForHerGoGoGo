/*
 * @lc app=leetcode id=120 lang=cpp
 *
 * [120] Triangle
 *
 * https://leetcode.com/problems/triangle/description/
 *
 * algorithms
 * Medium (41.64%)
 * Likes:    1491
 * Dislikes: 176
 * Total Accepted:    214.7K
 * Total Submissions: 513.7K
 * Testcase Example:  '[[2],[3,4],[6,5,7],[4,1,8,3]]'
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step
 * you may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * 
 * 
 * [
 * ⁠    [2],
 * ⁠   [3,4],
 * ⁠  [6,5,7],
 * ⁠ [4,1,8,3]
 * ]
 * 
 * 
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note:
 * 
 * Bonus point if you are able to do this using only O(n) extra space, where n
 * is the total number of rows in the triangle.
 * 
 */

// @lc code=start
class Solution {
public:
    int minimumTotal(vector<vector<int>>& nums) {
        int row = nums.size();

        vector<vector<long long>> dp(row, vector<long long> (row));

        dp[0][0] = nums[0][0];
        for (int i = 1; i < row; i++) {
            //each level
            for (int j = 0; j < nums[i].size(); j++) {
                
                dp[i][j] = INT_MAX;
                //like res = min(res, dp[row-1][i]);

                //from top left
                if (j > 0) dp[i][j] = min(dp[i][j], dp[i-1][j-1] + nums[i][j]);

                //from top right
                if (j < nums[i-1].size())
                    dp[i][j] = min(dp[i][j], dp[i-1][j] + nums[i][j]);

            }
        }

        //at last row
        long long res = INT_MAX;
        for (int i = 0 ; i < nums[row-1].size(); i++) {
            res = min(res, dp[row-1][i]);
        }

        return res;
        
    }
};
// @lc code=end

