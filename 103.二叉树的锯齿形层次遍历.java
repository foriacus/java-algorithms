import java.util.List;

/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层次遍历
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // recursion 先序遍历
        List<List<Integer>> res = new ArrayList<>();
        helper(root, 0, res);
        return res;
    }

    private void helper(TreeNode root, int level, List<List<Integer>> res) {
        if (root == null) return;
        if (level >= res.size()) {
            res.add(new ArrayList<>());
        }
        List<Integer> oneLevel = res.get(level);
        if (level % 2 == 0) {
            oneLevel.add(root.val);
        } else {
            oneLevel.add(0, root.val);
        }
        helper(root.left, level + 1, res);
        helper(root.right, level + 1, res);
    }
}
// @lc code=end

