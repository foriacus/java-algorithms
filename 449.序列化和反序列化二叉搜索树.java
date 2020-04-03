import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=449 lang=java
 *
 * [449] 序列化和反序列化二叉搜索树
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
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        Queue<Integer> q = new LinkedList<>();
        for (String s: arr) {
            if (s.length() > 0) {
                q.add(Integer.valueOf(s));
            }
        }
        return dfs(q);
    }

    private void dfs(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        sb.append(node.val);
        if (node.left != null) {
            sb.append(",");
            dfs(node.left, sb);
        }
        if (node.right != null) {
            sb.append(",");
            dfs(node.right, sb);
        }
    }

    private TreeNode dfs(Queue<Integer> queue) {
        if (queue.isEmpty()) return null;
        int cur = queue.poll();
        TreeNode root = new TreeNode(cur);
        Queue<Integer> small = new LinkedList<>();
        while (!queue.isEmpty() && queue.peek() < cur) {
            small.add(queue.poll());
        }
        root.left = dfs(small);
        root.right = dfs(queue);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
// @lc code=end

