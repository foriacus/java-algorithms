import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=958 lang=java
 *
 * [958] 二叉树的完全性检验
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
    public boolean isCompleteTree(TreeNode root) {
       // Level order traversal, if any nodes appears after a missing node then the tree is not a perfect binary tree.
        if (root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean missing = false;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node != null) {
                if (missing) return false;
                q.add(node.left);
                q.add(node.right);
            } else {
                missing = true;
            }
        }
        return true;
    }
}
// @lc code=end

