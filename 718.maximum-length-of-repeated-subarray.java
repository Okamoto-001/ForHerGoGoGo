/*
 * @lc app=leetcode id=718 lang=java
 *
 * [718] Maximum Length of Repeated Subarray
 *
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/
 *
 * algorithms
 * Medium (47.76%)
 * Likes:    831
 * Dislikes: 35
 * Total Accepted:    45K
 * Total Submissions: 93.9K
 * Testcase Example:  '[1,2,3,2,1]\n[3,2,1,4,7]'
 *
 * Given two integer arrays A and B, return the maximum length of an subarray
 * that appears in both arrays.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * Output: 3
 * Explanation: 
 * The repeated subarray with maximum length is [3, 2, 1].
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findLength(int[] A, int[] B) {
        int ans = 0;
        int Alen = A.length;
        int Blen = B.length;
        int [][] m = new int [Alen+1][Blen+1];

        for (int i = Alen-1; i >= 0; i--) {
            for (int j = Blen-1; j >= 0; j--) {
                if (A[i] == B[j])
                    m[i][j] = m[i+1][j+1] + 1;
                    if (ans < m[i][j])
                        ans = m[i][j];
            }
        }
        return ans;
    }
}
// @lc code=end

