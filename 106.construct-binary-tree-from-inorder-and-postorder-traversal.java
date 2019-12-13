/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (41.99%)
 * Likes:    1125
 * Dislikes: 25
 * Total Accepted:    179.8K
 * Total Submissions: 427.8K
 * Testcase Example:  '[9,3,15,20,7]\n[9,15,7,20,3]'
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * 
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * 
 * Return the following binary tree:
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return getAns(inorder, 0, inorder.length, postorder, 0, postorder.length, map);
    }

    public TreeNode getAns(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd, 
        HashMap<Integer, Integer> map ) {

            if (pStart == pEnd) return null;

            int rootValue = postorder[pEnd-1];
            TreeNode root = new TreeNode(rootValue);

            int inorderRootIndex = map.get(root.val);

            int leftTreeNum = inorderRootIndex - iStart;

            root.left = getAns(inorder, iStart, inorderRootIndex, postorder, pStart, pStart+leftTreeNum, map);
            root.right = getAns(inorder, inorderRootIndex+1, iEnd, postorder, pStart+leftTreeNum, pEnd-1, map);

            return root;
        }
}
// @lc code=end

