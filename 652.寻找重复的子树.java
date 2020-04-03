import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=652 lang=java
 *
 * [652] 寻找重复的子树
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
    // 方法一 Serialization
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> map = new HashMap<>();
        List<TreeNode> ans = new ArrayList<>();
        serialize(root, map, ans);
        return ans;
    }

    private String serialize(TreeNode root, Map<String, Integer> map, List<TreeNode> ans) {
        if (root == null) return "#";
        String key = String.valueOf(root.val) + ","
            + serialize(root.left, map, ans) + ","
            + serialize(root.right, map, ans);
        map.put(key, map.getOrDefault(key, 0) + 1);
        if (map.get(key) == 2) {
            ans.add(root);
        }
        return key;
    }
}
// @lc code=end

