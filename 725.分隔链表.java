/*
 * @lc app=leetcode.cn id=725 lang=java
 *
 * [725] 分隔链表
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
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        int len = 0;
        for (ListNode head = root; head != null; head = head.next) {
            ++len;
        }
        int l = len / k;
        int r = len % k;
        ListNode prev = null;
        ListNode head = root;
        for (int i = 0; i < k; ++i, --r) {
            res[i] = head;
            int part_len = l + ((r > 0) ? 1 : 0);
            for (int j = 0; j < part_len; ++j) {
                prev = head;
                head = head.next;
            }
            if (prev != null) prev.next = null;
        }
        return res;
    }
}
// @lc code=end

 