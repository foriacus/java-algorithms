import java.util.HashMap;
import java.util.Map;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=543 lang=java
 *
 * [543] 二叉树的直径
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
    Map<TreeNode, Integer> map = new HashMap<>();
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int res = getHeight(root.left) + getHeight(root.right);
        return Math.max(res, Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        if (map.containsKey(root)) {
            return map.get(root);
        }
        int h = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        map.put(root, h);
        return h;
    }
}
// @lc code=end

