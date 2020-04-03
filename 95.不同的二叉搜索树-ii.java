import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=95 lang=java
 *
 * [95] 不同的二叉搜索树 II
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
    public List<TreeNode> generateTrees(int n) {
        // 方法一 迭代法
        if (n == 0) return new ArrayList<TreeNode>();
        return helper(1, n);
    }

    private List<TreeNode> helper(int l, int r) {
        List<TreeNode> ans = new ArrayList<TreeNode>();
        if (l > r) {
            ans.add(null);
            return ans;
        }
        for (int i = l; i <= r; i++) {
            List<TreeNode> leftBranch = helper(res, l, i - 1);
            List<TreeNode> rightBranch = helper(res, i + 1, r);
            for (TreeNode left : leftBranch) {
                for (TreeNode right : rightBranch) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    ans.add(root);
                }
            }
        }
        return ans;
    }

    // 方法二 DP
}
// @lc code=end

