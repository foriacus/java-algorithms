import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javax.swing.tree.TreeNode;

import apple.laf.JRSUIUtils.Tree;

/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
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
    public List<Integer> preorderTraversal(TreeNode root) {
        // 迭代法1
        // Stack<TreeNode> stack = new Stack<>();
        // List<Integer> list = new LinkedList<>();
        // if (root == null) return list;
        
        // stack.push(root);
        // while(!stack.isEmpty()) {
        //     root = stack.pop();
        //     list.add(root.val);

        //     if (root.right != null) {
        //         stack.push(root.right);
        //     }
        //     if (root.left != null) {
        //         stack.push(root.left);
        //     }
        // }
        // return list;

        // 迭代法2
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        
        TreeNode p = root;
        while(p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                list.add(p.val);
                p = p.left;
            } else {
                TreeNode t = stack.peek();
                stack.pop();
                p = t.right;
            }
        }
        return list;
        // helper(root, list);
        // return list;
    }

    // 递归 - 前序遍历
    private void helper(TreeNode root, List<Integer> list) {
        if(root != null) {
            list.add(root.val);     
        }
        if (root.left != null) {
            helper(root.left, list);
        }
        if (root.right != null) {
            helper(root.right, list);
        }
    }
}
// @lc code=end

