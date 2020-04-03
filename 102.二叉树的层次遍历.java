import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层次遍历
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

/**
 *     1
 *    / \
 *   2   3
 *  / \ / \
 * 4  5 6  7
 * 
 * [[1], [2,3], [4,5,6,7]]
 * 
 * 
 */
class Solution {
    List<List<Integer>> res;
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    Queue<TreeNode> queue;
    public List<List<Integer>> levelOrder1(TreeNode root) {
        res = new ArrayList<>();
        queue = new LinkedList<>();
        if (root == null) return res;
        helper(root);
        return res;
    }

    // bfs
    private void helper(TreeNode root) {
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                // Retrieves and removes the head of this queue. 
                TreeNode p = queue.remove();
                tmp.add(p.val);
                if (p.left != null) {
                    queue.add(p.left);
                }
                if (p.right != null) {
                    queue.add(p.right);
                }
            }
            res.add(tmp);
        }
    }

    // dfs
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return ans;
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int depth) {
        if (depth == ans.size()) {
            ans.add(new ArrayList<Integer>());
        }
        // 先序遍历
        ans.get(depth).add(root.val); // pre-order
        if (root.left != null) {
            dfs(root.left, depth + 1);
        }
        if (root.right != null) {
            dfs(root.right, depth + 1);
        }
    }
}
// @lc code=end

