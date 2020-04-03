import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
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
    List<List<Integer>> res;
    List<Integer> cur;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<List<Integer>>();
        cur = new ArrayList<>();
        dfs(root, sum);
        return res;
    }

    private void dfs(TreeNode root, int sum) {
        if(root == null) return;
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                cur.add(root.val);
                res.add(new ArrayList<>(cur));
                // why ?
                cur.remove(cur.size() - 1);
                return;
            }
        }
        cur.add(root.val);
        int new_sum = sum - root.val;
        dfs(root.left, new_sum);
        dfs(root.right, new_sum);
        cur.remove(cur.size() - 1);
    }
}
// @lc code=end
