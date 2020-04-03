import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=513 lang=java
 *
 * [513] 找树左下角的值
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
    private int max_row = 0;
    private int ans = 0;
    // The first node visited in the deepest row is the answer.
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 1);
        return ans;
    }

    private void dfs(TreeNode root, int depth) {
        if (max_row < depth) {
            max_row = depth;
            ans = root.val;
        }
        if (root.left != null) {
            dfs(root.left, depth + 1);
        }
        if (root.right != null) {
            dfs(root.right, depth + 1);
        }
    }


    // 从右往左BFS，最后一个结点的值即是结果。
    public int findBottomLeftValue1(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            root = q.poll();
            if (root.right != null) {
                q.add(root.right);
            }
            if (root.left != null) {
                q.add(root.left);
            }
        }
        return root.val;
    }
}

// @lc code=end

