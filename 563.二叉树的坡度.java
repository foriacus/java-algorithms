/*
 * @lc app=leetcode.cn id=563 lang=java
 *
 * [563] 二叉树的坡度
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
    private int ans;
    public int findTilt(TreeNode root) {
        // 后序遍历
        ans = 0;
        postorder(root);
        return ans;
    }

    private int postorder(TreeNode root) {
        if (root == null) return 0;
        int leftSum = postorder(root.left);
        int rightSum = postorder(root.right);
        ans += Math.abs(leftSum - rightSum);
        return root.val + rightSum + leftSum;
    }
}
// @lc code=end

