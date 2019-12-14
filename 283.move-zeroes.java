/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 *
 * https://leetcode.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (55.75%)
 * Likes:    2642
 * Dislikes: 95
 * Total Accepted:    574.6K
 * Total Submissions: 1M
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * Example:
 * 
 * 
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * 
 * Note:
 * 
 * 
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * 
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int zeroes = 0;
        int pre = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                zeroes++;
            }
            else {
                nums[pre] = nums[i];
                pre++;
            }
        }
        
        //mark up start from pre
        while (zeroes != 0) {
            nums[pre] = 0;
            pre++;
            zeroes--;
        }
        
    }
}
// @lc code=end

