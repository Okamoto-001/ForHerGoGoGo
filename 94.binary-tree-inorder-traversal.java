/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Medium (59.32%)
 * Likes:    2160
 * Dislikes: 94
 * Total Accepted:    571.7K
 * Total Submissions: 960.3K
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * Example:
 * 
 * 
 * Input: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 * 
 * Output: [1,3,2]
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;

        while(cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            ans.add(cur.val);
            cur = cur.right;
        }
        return ans;
    }


    //     List<Integer> ans = new ArrayList<>();
    //     dfs(ans, root);
    //     return ans;
    // }

    // public void dfs(List<Integer> ans, TreeNode root) {
    //     if (root == null) return;

    //     dfs(ans, root.left);

    //     ans.add(root.val);

    //     dfs(ans, root.right);
    // }

            // # 1 stack
        // ArrayList<Integer> result = new ArrayList<>();
        // Stack<TreeNode> stack = new Stack<>();

        // TreeNode cur = root;
        // while(cur != null || stack.size() > 0) {
        //     //push into stack
        //     while (cur != null) {
        //         stack.push(cur);
        //         //dfs
        //         cur = cur.left;
        //     }

        //     //null
        //     cur = stack.pop();
        //     result.add(cur.val);
        //     cur = cur.right;
        // }
        // return result;
}
// @lc code=end

