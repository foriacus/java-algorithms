import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=662 lang=java
 *
 * [662] 二叉树最大宽度
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
    public int widthOfBinaryTree1(TreeNode root) {
        // DFS
        List<Integer> lefts = new ArrayList<>();
        int[] res = new int[1];
        dfs(root, 1, 0, lefts, res);
        return res[0];
    }

    private void dfs(TreeNode node, int id, int depth, List<Integer> lefts, int[] res) {
        if (node == null) return;
        if (depth >= lefts.size()) lefts.add(id); // add left most node
        res[0] = Integer.max(res[0], id + 1 - lefts.get(depth));
        dfs(node.left, id * 2, depth + 1, lefts, res);
        dfs(node.right, id * 2 + 1, depth + 1, lefts, res);
    }

    // bfs
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        queue.offer(root);
        list.add(1);
        int res = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = size; i > 0; i--) {
                TreeNode cur = queue.poll();
                Integer curIndex = list.removeFirst();
                if (cur.left != null) {
                    queue.offer(cur.left);
                    list.add(curIndex * 2);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                    list.add(curIndex * 2 + 1);
                }
            }
            if (list.size() >= 2) {
                res = Math.max(res, list.getLast() - list.getFirst() + 1);
            }
        }
        return res;
    }
}
// @lc code=end

