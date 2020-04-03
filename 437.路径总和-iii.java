/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] 路径总和 III
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
    public int pathSum1(TreeNode root, int sum) {
        // recursion 递归
        if (root == null) return 0;
        return numberOfPaths(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int numberOfPaths(TreeNode root, int left) {
        if (root == null) return 0;
        left -= root.val;
        return (left == 0 ? 1 : 0) + numberOfPaths(root.left, left) + numberOfPaths(root.right, left);
    }

    // prefix sum
    public int pathSum(TreeNode root, int sum) {

    }
}
// @lc code=end

