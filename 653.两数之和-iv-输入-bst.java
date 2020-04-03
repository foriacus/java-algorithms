import java.util.List;

/*
 * @lc app=leetcode.cn id=653 lang=java
 *
 * [653] 两数之和 IV - 输入 BST
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
    List<Integer> nums = new ArrayList<>();
    public boolean findTarget1(TreeNode root, int k) {
        inorder(root, nums);
        int l = 0;
        int r = nums.size() - 1;
        while (l < r) {
            int sum = nums.get(l) + nums.get(r);
            if (sum == k) {
                return true;
            } else if (sum < k) {
                ++l;
            } else {
                --r;
            }
        }
        return false;
    }

    // 通过中序遍历拿到排序数组
    private void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }

    // HashSet

    // 层序遍历 + HashSet
}
// @lc code=end

