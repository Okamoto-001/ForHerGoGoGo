/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (51.05%)
 * Likes:    1985
 * Dislikes: 55
 * Total Accepted:    470.3K
 * Total Submissions: 921K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * 
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 
 * return its level order traversal as:
 * 
 * [
 * ⁠ [3],
 * ⁠ [9,20],
 * ⁠ [15,7]
 * ]
 * 
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        dfs(root, 0, ans);
        return ans;
    }

    public void dfs(TreeNode root, int level, List<List<Integer>> ans) {
        if (root == null) return;

        if (ans.size() <= level) {
            ans.add(new ArrayList<>());
        }
        //get this level list and add number to it
        ans.get(level).add(root.val);

        //go deep
        dfs(root.left, level+1, ans);
        dfs(root.right, level+1, ans);
    }
}
// @lc code=end

