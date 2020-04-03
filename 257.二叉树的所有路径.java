import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

import apple.laf.JRSUIUtils.Tree;

/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
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
    
    
    // public List<String> binaryTreePaths(TreeNode root) {
    //     List<String> list = new LinkedList<>();
    //     Stack<Integer> stack = new LinkedList<>();
    //     if (root == null) return list;
    //     dfs(root);
    //     return list;
    // }

    // 递归法
    /**
     * 时间复杂度：每个节点只会被访问一次，因此时间复杂度为 O(N)，其中 N 表示节点数目。
     * 空间复杂度：O(N)。这里不考虑存储答案 paths 使用的空间，
     * 仅考虑额外的空间复杂度。额外的空间复杂度为递归时使用的栈空间，
     * 在最坏情况下，当二叉树中每个节点只有一个孩子节点时，递归的层数为 N，
     * 此时空间复杂度为 O(N)。在最好情况下，当二叉树为平衡二叉树时，
     * 它的高度为 log(N)，此时空间复杂度为 O(log(N))。
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        helper(root, "", res);
        return res;
    }

    private void helper(TreeNode root, String path, List<String> res) {
        if (root != null) {
            path += Integer.toString(root.val);
            if (root.left == null && root.right == null) {
                res.add(path);
            }

            path += "->";
            helper(root.left, path, res);
            helper(root.right, path, res);
        }
    }

    // bfs
    // public List<String> binaryTreePaths(TreeNode root) {
    //     List<String> res = new ArrayList<>();
    //     if (root == null) return res;

    //     Queue<TreeNode> queue = new LinkedList<>();
    //     queue.add(root);

    //     while(!queue.isEmpty() || root != null ) {
            
    //     }
    // }

}
// @lc code=end

