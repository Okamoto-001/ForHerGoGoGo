/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 *
 * https://leetcode.com/problems/3sum/description/
 *
 * algorithms
 * Medium (25.32%)
 * Likes:    5007
 * Dislikes: 608
 * Total Accepted:    716.3K
 * Total Submissions: 2.8M
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the
 * sum of zero.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate triplets.
 * 
 * Example:
 * 
 * 
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is:
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len-2; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                
                int low = i+1, high = len-1, needSum = 0-nums[i];

                while (low < high) {
                    if (nums[low] + nums[high] == needSum) {
                        ans.add(Arrays.asList(nums[low], nums[high], nums[i]));

                        //skip repeat number
                        while (low < high && nums[low] == nums[low+1]) low++;
                        while (low < high && nums[high] == nums[high-1]) high--;
                        low++; high--;
                    }
                    else if (nums[low] + nums[high] < needSum) low++;
                    else high--;
                }
            }
        }
        return ans;
    }
}

// @lc code=end

//[-2,-1,0,0,1,2,2]

//  i    nums[i]    low:i+1      high:len-1
//  0       -2      -1           2
//  1       -1      -1           2 -->[-1, -1, 2]
//  2       0        0           2