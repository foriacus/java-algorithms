import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=404 lang=java
 *
 * [404] 左叶子之和
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
    // 方法一 递归
    // public int sumOfLeftLeaves(TreeNode root) {
    //     if (root == null) return 0;
    //     if (root.left != null && root.left.left == null && root.left.right == null) {
    //         return root.left.val + sumOfLeftLeaves(root.right);
    //     }
    //     return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    // }

    // 方法二 遍历
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int sum = 0;
        while (!q.isEmpty()) {
            TreeNode n = q.peek();
            q.poll();

            TreeNode l = n.left;
            if (l != null) {
                if (l.left == null && l.right == null) {
                    sum += l.val;
                } else {
                    q.add(l);
                }
            }
            if (n.right != null) {
                q.add(n.right);
            }
        }
        return sum;
    }
}
// @lc code=end

