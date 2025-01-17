/*
 * @lc app=leetcode.cn id=938 lang=java
 *
 * [938] 二叉搜索树的范围和
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
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;
        int res = 0;
        if (root.val >= L && root.val <= R) {
            res += root.val;
            res += rangeSumBST(root.left, L , R);
            res += rangeSumBST(root.right, L ,R);
        } else if (root.val < L) {
            res +=  rangeSumBST(root.right, L ,R);
        } else if (root.val > R) {
            res += rangeSumBST(root.left, L , R);
        }
        return res;
    }
}
// @lc code=end

