import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=508 lang=java
 *
 * [508] 出现次数最多的子树元素和
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
    private int max_freq = 1;
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> freqs = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        treeSum(root, freqs, ans);
        return convertListToArray(ans);
    }

    private int treeSum(TreeNode root, Map<Integer, Integer> freqs, List<Integer> ans) {
        if (root == null) return 0;
        int sum = root.val +
            treeSum(root.left, freqs, ans) +
            treeSum(root.right, freqs, ans);
        freqs.put(sum, freqs.getOrDefault(sum, 0) + 1);
        int freq = freqs.get(sum);
        if (freq > max_freq) {
            max_freq = freq;
            ans.clear();
        }
        if (freq == max_freq) {
            ans.add(sum);
        }
        return sum;
    }

    public static int[] convertListToArray(List<Integer> list) {
        int size = list.size();
        int[] result = new int[size];
        Integer[] temp = list.toArray(new Integer[size]);
        for (int n = 0; n < size; ++n) {
            result[n] = temp[n];
        }
        return result;
    }
}
// @lc code=end

