import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=538 lang=java
 *
 * [538] 把二叉搜索树转换为累加树
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
    private int sum;
    public TreeNode convertBST1(TreeNode root) {
        // recursion
        sum = 0;
        helper(root);
        return root;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.right);
        root.val = root.val + sum;
        sum = root.val;
        helper(root.left);
    }

    // 遍历法
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.right;
            }
            p = stack.peek();
            stack.pop();
            p.val += sum;
            sum = p.val;
            p = p.left;
        }
        return root;
    }
}
// @lc code=end

