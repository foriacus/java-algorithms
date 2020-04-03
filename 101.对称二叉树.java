import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
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
    // 递归
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSym(root.left, root.right);
    }

    private boolean isSym(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if (l == null || r == null) return false;

        return l.val == r.val && isSym(l.left, r.right)
          && isSym(l.right, r.left);
    }

    // 迭代
}
// @lc code=end

