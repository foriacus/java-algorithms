import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        if (root != null) {
          helper(root, list);
        }
        return list;
    }

    // 递归
    // private void helper(TreeNode root, List<Integer> list) {
    //     if (root.left != null) {
    //         helper(root.left, list);
    //     }
    //     list.add(root.val);
    //     if (root.right != null) {
    //         helper(root.right, list);
    //     }
    // }

    // 迭代
    private void helper(TreeNode root, List<Integer> list) {
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.add(root);
                root = root.left;
            }

            // left
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
    }
}
// @lc code=end

