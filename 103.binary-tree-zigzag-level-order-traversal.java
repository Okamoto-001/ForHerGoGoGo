import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 *
 * algorithms
 * Medium (44.17%)
 * Likes:    1360
 * Dislikes: 76
 * Total Accepted:    277.7K
 * Total Submissions: 628.3K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
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
 * return its zigzag level order traversal as:
 * 
 * [
 * ⁠ [3],
 * ⁠ [20,9],
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        TreeNode cur = root;
        List<List<Integer>> ans = new ArrayList<>();

        if (cur == null) return ans;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(cur);
        
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            List<Integer> temp = new ArrayList<>();

            while (!stack1.isEmpty()) {
                cur = stack1.pop();
                temp.add(cur.val);
                //Left ---> Right
                if (cur.left != null) stack2.push(cur.left);
                if (cur.right != null) stack2.push(cur.right);
            }
            ans.add(temp);

            // clean temp
            temp = new ArrayList<>();

            while (stack2.size() > 0) {
                cur = stack2.pop();
                temp.add(cur.val);
                //Right ---> Left
                if (cur.right != null) stack1.push(cur.right);
                if (cur.left != null) stack1.push(cur.left);
            }

            // only add temp to ans when it is not empty
            if (!temp.isEmpty()) ans.add(temp);
        }

        return ans;
    }
}
// @lc code=end

