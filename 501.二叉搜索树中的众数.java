import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=501 lang=java
 *
 * [501] 二叉搜索树中的众数
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
    private int max;
    HashMap<Integer, Integer> map;
    public int[] findMode(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        max = 0;
        map = new HashMap<>();
        inorder(root, map);
        System.out.println(max);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                res.add(entry.getKey());
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    private void inorder(TreeNode node, HashMap<Integer, Integer> map) {
        if (node == null) return;
        inorder(node.left, map);
        if (!map.containsKey(node.val)) {
            map.put(node.val, 1);
        } else {
            map.put(node.val, map.get(node.val) + 1);
        }
        max = Math.max(max, map.get(node.val));
        inorder(node.right, map);
    }
}
// @lc code=end

