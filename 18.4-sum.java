/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 *
 * https://leetcode.com/problems/4sum/description/
 *
 * algorithms
 * Medium (31.99%)
 * Likes:    1389
 * Dislikes: 270
 * Total Accepted:    279.8K
 * Total Submissions: 874.7K
 * Testcase Example:  '[1,0,-1,0,-2,2]\n0'
 *
 * Given an array nums of n integers and an integer target, are there elements
 * a, b, c, and d in nums such that a + b + c + d = target? Find all unique
 * quadruplets in the array which gives the sum of target.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate quadruplets.
 * 
 * Example:
 * 
 * 
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * 
 * A solution set is:
 * [
 * ⁠ [-1,  0, 0, 1],
 * ⁠ [-2, -1, 1, 2],
 * ⁠ [-2,  0, 0, 2]
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len-3; i++) {
            
            //skip repeat number
            if (i == 0 || nums[i] != nums[i-1]) {
                
                // j is the next to the i
                for (int j = i+1; j < len -2; j++) {

                    //skip repeat
                    if (j == i+1 || nums[j] != nums[j-1]) {
                        int low = j +1, high = len-1, needSum = target - nums[i] - nums[j];

                        while (low < high) {
                            if (nums[low] + nums[high] == needSum) {
                                ans.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));

                                //move low and high to skip repeat number
                                while (low < high && nums[low] == nums[low+1]) low++;
                                while (low < high && nums[high] == nums[high-1]) high--;
                                low++; high--;
                            }
                            else if (nums[low] + nums[high] < needSum) low++;
                            else high--;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
// @lc code=end

