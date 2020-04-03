import java.net.InetAddress;

/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
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
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return ans;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;
        int l = Math.max(0, helper(node.left));
        int r = Math.max(0, helper(node.right));
        ans = Math.max(ans, l + r + node.val);
        return Math.max(l, r) + node.val;
    }
}
// @lc code=end

