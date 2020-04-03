/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第K小的元素
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
    private int count = 1;
    private int res;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return res;
    }

    private void inorder(TreeNode root, int k) {
        if (root == null) return;
        inorder(root.left, k);
        if (count++ == k) {
            res = root.val;
            return;
        }
        inorder(root.right, k);
    }

    // 方法二 stack
}
// @lc code=end

