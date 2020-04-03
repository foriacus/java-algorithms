/*
 * @lc app=leetcode.cn id=530 lang=java
 *
 * [530] 二叉搜索树的最小绝对差
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
    private int pre = -1;
    private int minDiff;
    public int getMinimumDifference(TreeNode root) {
        minDiff = Integer.MAX_VALUE;
        inorder(root);
        return minDiff;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (pre != -1) {
            minDiff = Math.min(minDiff, root.val - pre);
        }
        pre = root.val;
        inorder(root.right);
    }
}
// @lc code=end

