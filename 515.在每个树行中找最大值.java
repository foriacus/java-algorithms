/*
 * @lc app=leetcode.cn id=515 lang=java
 *
 * [515] 在每个树行中找最大值
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
    // Inorder traversal + depth info
    // 如果我们想用迭代的方法来解，可以用先序遍历，
    // 这样的话就需要维护一个深度变量depth，来记录当前结点的深度，
    // 如果当前深度大于结果res的长度，说明这个新一层，我们将当前结点值加入结果res中，如果不大于res的长度的话，我们用当前结点值和结果res中对应深度的那个结点值相比较，取较大值赋给结果res中的对应深度位置
    private List<Integer> res;
    public List<Integer> largestValues1(TreeNode root) {
        res = new ArrayList<>();
        inorder(root, 0 , res);
        return res;
    }

    private void inorder(TreeNode root, int depth, List<Integer> res) {
        if (root == null) return;
        while (res.size() <= depth) {
            res.add(Integer.MIN_VALUE);
        }
        inorder(root.left, depth + 1, res);
        res.set(depth, Math.max(res.get(depth), root.val));
        inorder(root.right, depth + 1, res);
    }

    // 层序遍历
    public List<Integer> largestValues1(TreeNode root) {

    }
}
// @lc code=end

