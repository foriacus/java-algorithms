import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
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
    private boolean helper(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double inorder = - Double.MAX_VALUE;
        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
    public boolean isValidBST(TreeNode root) {
        // 因为二叉搜索树中序遍历是递增的,所以我们可以中序遍历判断前一数是否小于后一个数.
        // 中序遍历法
        return helper(root);
    }
}
// @lc code=end

