import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=109 lang=java
 *
 * [109] 有序链表转换二叉搜索树
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ListNode node = head;
        List<ListNode> list = new ArrayList<>();
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        return helper(list, 0, list.size() - 1);
    }

    private TreeNode helper(List<ListNode> list, int l, int r) {
        if (l > r) return null;
        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(list.get(mid).val);
        root.left = helper(list, l, mid - 1);
        root.right = helper(list, mid + 1, r);
        return root;
    }
}
// @lc code=end

