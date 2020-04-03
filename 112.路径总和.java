import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
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
    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }

        boolean l = hasPathSum(root.left, sum - root.val);
        boolean r = hasPathSum(root.right, sum - root.val);
        return l || r;
    }

    // 方法二 遍历
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode t = stack.peek();
            stack.pop();

            if (t.left == null && t.right == null) {
                if (t.val == sum) return true;
            }

            if (t.right != null) {
                t.right.val += t.val;
                stack.push(t.right);
            }

            if (t.left != null) {
                t.left.val += t.val;
                stack.push(t.left);
            }
        }
        return false;
    }
}
// @lc code=end

