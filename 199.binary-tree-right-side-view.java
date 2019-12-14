import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
 *
 * https://leetcode.com/problems/binary-tree-right-side-view/description/
 *
 * algorithms
 * Medium (50.66%)
 * Likes:    1473
 * Dislikes: 77
 * Total Accepted:    214.7K
 * Total Submissions: 423.8K
 * Testcase Example:  '[1,2,3,null,5,null,4]'
 *
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 * 
 * ⁠  1            <---
 * ⁠/   \
 * 2     3         <---
 * ⁠\     \
 * ⁠ 5     4       <---
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
    public void dfs(TreeNode root, int level, List<Integer> ans) {
        if (root == null) return;

        if (level == ans.size()) {
            ans.add(root.val);
        }

        dfs(root.right, level+1, ans);
        dfs(root.left, level+1, ans);
    }

        //dfs 0 : root 
        //dfs 1 : this level first, -> ans.size = 1 (root), add -> ans.size = 2
        //dfs 2 : ans.size=2, add -> 3
    public List<Integer> rightSideView(TreeNode root) {
        // # 2 DFS
        List<Integer> ans = new ArrayList<>();

        dfs(root, 0, ans);
        return ans;
        
        
        // # 1  BFS : O (n)
        // List<Integer> ans = new ArrayList<>();
        // if (root == null) return ans;

        // Queue<TreeNode> queue = new LinkedList<>();


        // queue.offer(root);
        // while (!queue.isEmpty()) {

        //     int nodeNumbers = queue.size();
        //     //each level node number
        //     for (int i = 0; i < nodeNumbers; i++) {
        //         //last one add to 
        //         TreeNode cur = queue.poll();
        //         if (i == nodeNumbers-1) {
        //             ans.add(cur.val);
        //         }
        //         if (cur.left != null) {
        //             queue.offer(cur.left);
        //         }
        //         if (cur.right != null) {
        //             queue.offer(cur.right);
        //         }
        //     }
        // }
        // return ans;

    }
}
// @lc code=end

