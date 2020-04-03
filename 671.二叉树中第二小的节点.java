/*
 * @lc app=leetcode.cn id=671 lang=java
 *
 * [671] 二叉树中第二小的节点
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
    public int findSecondMinimumValue(TreeNode root) {
        // root.val是最小的
        if (root == null) return -1;
        return dfs(root, root.val);
    }

    private int dfs(TreeNode root, int s1) {
        if (root == null) return -1;
        // root.val 应该是最小的，如果它都大于s1,那么它就是最小的
        if (root.val > s1) return root.val;
        int sl = dfs(root.left, s1);
        int sr = dfs(root.right, s1);
        if (sl == -1) return sr;
        if (sr == -1) return sl;
        return Math.min(sl, sr);
    }
}
// @lc code=end

