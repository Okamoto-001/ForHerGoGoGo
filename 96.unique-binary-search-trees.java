/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 *
 * https://leetcode.com/problems/unique-binary-search-trees/description/
 *
 * algorithms
 * Medium (48.67%)
 * Likes:    2295
 * Dislikes: 87
 * Total Accepted:    234.8K
 * Total Submissions: 482.4K
 * Testcase Example:  '3'
 *
 * Given n, how many structurally unique BST's (binary search trees) that store
 * values 1 ... n?
 * 
 * Example:
 * 
 * 
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 * 
 * ⁠  1         3     3      2      1
 * ⁠   \       /     /      / \      \
 * ⁠    3     2     1      1   3      2
 * ⁠   /     /       \                 \
 * ⁠  2     1         2                 3
 * 
 * 
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {
        if (n == 0) return 0;

        return getAns(1, n);
    }

    public int getAns(int start, int end) {
        int ans = 0;

        // only one number
        if (start >= end) {
            return 1;
        }

        //try each number as root
        for (int i = start; i <= end; i++) {
            int leftTreeSum = getAns(start, i-1);
            int rightTreeSum = getAns(i+1, end);

            ans += leftTreeSum*rightTreeSum;
        }
        return ans;
    }
}
// @lc code=end

