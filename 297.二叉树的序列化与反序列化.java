import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "#";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val)
        .append(",").append(serialize(root.left))
        .append(",").append(serialize(root.right));
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        if (arr.length == 0) return null;
        Queue<String> queue = new LinkedList<>();
        for (String s : arr) {
            queue.add(s);
        }
        return des(queue);
    }

    private TreeNode des(Queue<String> queue) {
        if (queue.size() == 0) return null;
        String cur = queue.poll();
        if ("#".equals(cur)) return null;
        TreeNode root = new TreeNode(Integer.valueOf(cur));
        root.left = des(queue);
        root.right = des(queue);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
// @lc code=end

