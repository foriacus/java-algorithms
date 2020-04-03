import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        if (root == null) return list;

        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode p = stack.peek();
            stack.pop();
            // ！！这里很关键，注意是加载List的首位
            list.add(0, p.val);
            if (p.left != null) stack.push(p.left);
            if (p.right != null) stack.push(p.right);
        }
        return list;
    }
}
// @lc code=end

