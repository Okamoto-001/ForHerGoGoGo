/*
 * @lc app=leetcode id=53 lang=cpp
 *
 * [53] Maximum Subarray
 *
 * https://leetcode.com/problems/maximum-subarray/description/
 *
 * algorithms
 * Easy (45.25%)
 * Likes:    5902
 * Dislikes: 248
 * Total Accepted:    728.9K
 * Total Submissions: 1.6M
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 * 
 * Example:
 * 
 * 
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * 
 * 
 * Follow up:
 * 
 * If you have figured out the O(n) solution, try coding another solution using
 * the divide and conquer approach, which is more subtle.
 * 
 */

// @lc code=start
class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        

        vector<int> dp(nums.size()+1, 0);

        dp[0] = nums[0];

        int res = dp[0];
        int len = nums.size();

 
        for (int i = 1; i < len; i++) {
            //if dp[i-1] smaller than 0, we choose nums[i] as new one
            dp[i] = max(dp[i-1], 0) + nums[i];
            
            res = max(res, dp[i]);
        }

        return res;
  
    }
};
// @lc code=end

