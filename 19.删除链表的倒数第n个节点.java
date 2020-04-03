/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第N个节点
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = head;
        while (n-- > 0) fast = fast.next;
        ListNode prev = dummy;
        while (fast != null) {
            fast = fast.next;
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return dummy.next;
    }
}
// @lc code=end

