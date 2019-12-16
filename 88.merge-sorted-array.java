/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 *
 * https://leetcode.com/problems/merge-sorted-array/description/
 *
 * algorithms
 * Easy (37.51%)
 * Likes:    1471
 * Dislikes: 3297
 * Total Accepted:    456.1K
 * Total Submissions: 1.2M
 * Testcase Example:  '[1,2,3,0,0,0]\n3\n[2,5,6]\n3'
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
 * one sorted array.
 * 
 * Note:
 * 
 * 
 * The number of elements initialized in nums1 and nums2 are m and n
 * respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to
 * m + n) to hold additional elements from nums2.
 * 
 * 
 * Example:
 * 
 * 
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 
 * Output: [1,2,2,3,5,6]
 * 
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m-1, index2 = n-1, indexMerge = m+n-1;

        while (indexMerge >= 0) {
            if (index1 < 0) {
                nums1[indexMerge--] = nums2[index2--];
            } else if (index2 < 0) {
                nums1[indexMerge--] = nums1[index1--];
            } else if (nums1[index1] > nums2[index2]) {
                nums1[indexMerge--] = nums1[index1--];
            } else {
                nums1[indexMerge--] = nums2[index2--];
            }
        }

        // int i = 0, j = 0;
        // while (j < n) {
        //     if (i == m+j) {
        //         while (j < n) {
        //             nums1[m+j] = nums2[j];
        //             j++;
        //         }
        //         return;
        //     }

        //     if (nums2[j] < nums1[i]) {
        //         for (int k = m+j; k > i; k--) {
        //             nums1[k] = nums1[k-1];
        //         }
        //         nums1[i] = nums2[j];
        //         i++; j++;
        //     }
        //     else i++;
        // }
    }
}
// @lc code=end

