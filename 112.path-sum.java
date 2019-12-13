/*
 * @lc app=leetcode id=112 lang=java
 *
 * [112] Path Sum
 *
 * https://leetcode.com/problems/path-sum/description/
 *
 * algorithms
 * Easy (39.10%)
 * Likes:    1247
 * Dislikes: 393
 * Total Accepted:    376.1K
 * Total Submissions: 959.2K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,null,1]\n22'
 *
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given the below binary tree and sum = 22,
 * 
 * 
 * ⁠     5
 * ⁠    / \
 * ⁠   4   8
 * ⁠  /   / \
 * ⁠ 11  13  4
 * ⁠/  \      \
 * 7    2      1
 * 
 * 
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;

        return dfs(root, sum);
    }

    public boolean dfs(TreeNode root, int needNum) {
        //get the leaf node
        if (root.left == null && root.right == null)
            return needNum == root.val;

        // //didn't get the leaf, but root.val >= needNum`
        // if (Math.abs(root.val) >= Math.abs(needNum))
        //     return false;

        //we try root.left, if null we back and try root.right
        if (root.left == null)
            return dfs(root.right, needNum-root.val);

        //if root.right == null, try left
        if (root.right == null)
            return dfs(root.left, needNum-root.val);

        return (dfs(root.left, needNum-root.val) || dfs(root.right, needNum-root.val));

    }
}
// @lc code=end

