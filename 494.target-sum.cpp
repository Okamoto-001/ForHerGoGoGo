/*
 * @lc app=leetcode id=494 lang=cpp
 *
 * [494] Target Sum
 *
 * https://leetcode.com/problems/target-sum/description/
 *
 * algorithms
 * Medium (46.07%)
 * Likes:    1843
 * Dislikes: 85
 * Total Accepted:    125.4K
 * Total Submissions: 271.8K
 * Testcase Example:  '[1,1,1,1,1]\n3'
 *
 * 
 * You are given a list of non-negative integers, a1, a2, ..., an, and a
 * target, S. Now you have 2 symbols + and -. For each integer, you should
 * choose one from + and - as its new symbol.
 * ⁠
 * 
 * Find out how many ways to assign symbols to make sum of integers equal to
 * target S.  
 * 
 * 
 * Example 1:
 * 
 * Input: nums is [1, 1, 1, 1, 1], S is 3. 
 * Output: 5
 * Explanation: 
 * 
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * 
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 * 
 * 
 * 
 * Note:
 * 
 * The length of the given array is positive and will not exceed 20. 
 * The sum of elements in the given array will not exceed 1000.
 * Your output answer is guaranteed to be fitted in a 32-bit integer.
 * 
 * 
 */

// @lc code=start
class Solution {
public:
    int findTargetSumWays(vector<int>& nums, int S) {
        vector<unordered_map<int, int>> memo(nums.size()+1);

        return dfs(nums, 0, S, memo);
    }

    int dfs(vector<int>& nums, int start, int curSum, vector<unordered_map<int, int>>& memo) {
        if (start == nums.size()) return curSum == 0;
        if (curSum == INT_MIN || curSum == INT_MAX) return 0;
        if (memo[start].count(curSum)) return memo[start][curSum];
        int plus = dfs(nums, start+1, curSum+nums[start], memo);
        int mins = dfs(nums, start+1, curSum-nums[start], memo);

        return memo[start][curSum] = plus + mins;
    }
};
// @lc code=end

