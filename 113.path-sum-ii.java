/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
 *
 * https://leetcode.com/problems/path-sum-ii/description/
 *
 * algorithms
 * Medium (43.33%)
 * Likes:    1212
 * Dislikes: 42
 * Total Accepted:    276.1K
 * Total Submissions: 637K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,5,1]\n22'
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
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
 * ⁠/  \    / \
 * 7    2  5   1
 * 
 * 
 * Return:
 * 
 * 
 * [
 * ⁠  [5,4,11,2],
 * ⁠  [5,8,4,5]
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();

        if ( root == null) return ans;

        dfs(root, sum, new ArrayList<>(), ans);
        return ans;
    }

    public void dfs(TreeNode root, int needSum, ArrayList<Integer> temp, List<List<Integer>> ans) {
        //leaf
        if (root.left == null && root.right == null) {
            if (needSum == root.val) {
                //add to ans
                temp.add(root.val);
                ans.add(new ArrayList<>(temp));
                //remove this root.val for other branch to add
                temp.remove(temp.size()-1);
            }
            return;
        }
        //root.left == null, go right
        if (root.left == null) {
            temp.add(root.val);
            dfs(root.right, needSum-root.val, temp, ans);
            //return from recursion, remove last node for other branch
            temp.remove(temp.size()-1);
            return;
        }

        //root.right == null, go left
        if (root.right == null) {
            temp.add(root.val);
            dfs(root.left, needSum-root.val, temp, ans);
            temp.remove(temp.size()-1);
            return;
        }

        //go left
        temp.add(root.val);
        dfs(root.left, needSum-root.val, temp, ans);
        temp.remove(temp.size()-1);

        //go right
        temp.add(root.val);
        dfs(root.right, needSum-root.val, temp, ans);
        temp.remove(temp.size()-1);
    }
}
// @lc code=end

