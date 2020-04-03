/*
 * @lc app=leetcode.cn id=147 lang=java
 *
 * [147] 对链表进行插入排序
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
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (head != null) {
            ListNode t = head.next;
            cur = dummy;
            while (cur.next != null && cur.next.val <= head.val) {
                cur = cur.next;
            }
            head.next = cur.next;
            cur.next = head;
            head = t;
        }
        return dummy.next;
    }
}
// @lc code=end

