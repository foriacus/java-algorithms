/*
 * @lc app=leetcode.cn id=222 lang=java
 *
 * [222] 完全二叉树的节点个数
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
    // 方法一
    // public int countNodes(TreeNode root) {
    //     if (root == null) return 0;
    //     TreeNode left = root;
    //     TreeNode right = root;
    //     int cntLeft = 0;
    //     int cntRight = 0;

    //     while (left != null) {
    //         left = left.left;
    //         cntLeft++;
    //     }
    //     while (right != null) {
    //         right = right.right;
    //         cntRight++;
    //     }
    //     if (cntLeft == cntRight) {
    //         return (int)Math.pow(2, cntLeft) - 1;
    //     }
    //     return countNodes(root.left) + countNodes(root.right) + 1;
    // }

    // 方法二
}
// @lc code=end

